package com.example.billerbacon.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

import kotlinx.coroutines.launch

//ViewModel para gestinar el inicio de sesión
class ViewModelLogin : ViewModel() {
    private val auth: FirebaseAuth = Firebase.auth
    private val _cargando = MutableLiveData(false)
    private val _mensajeError = MutableLiveData<String?>()
    val mensajeError: LiveData<String?> get() = _mensajeError

    //Función necesaria para validar el usuario y la contraseña
    fun iniciarSesion(email: String, clave: String, home: () -> Unit) = viewModelScope.launch {
        _cargando.value = true
        try {
            auth.signInWithEmailAndPassword(email, clave).addOnCompleteListener { task ->

                if (task.isSuccessful) {
                    // Inicio de sesión exitoso
                    home()
                } else {
                    // Inicio de sesión fallido
                    _mensajeError.value = "Correo electrónico o clave incorrectos"
                    _mensajeError.value = null
                }
            }
        } catch (ex: FirebaseAuthInvalidCredentialsException) {

            _mensajeError.value = "Las credenciales proporcionadas son incorrectas o han expirado"
            Log.d("BillerBacon", "IniciarSesion: Credenciales inválidas - ${ex.message}")
            _mensajeError.value = null
        } catch (ex: Exception) {

            _mensajeError.value =
                "Error en el inicio de sesión: ${ex.message ?: "Error desconocido"}"
            Log.d("BillerBacon", "IniciarSesion: ${ex.message}")
            _mensajeError.value = null
        }
    }

    //Función necesaria para crear usuario
    fun registrarUsuario(email: String, clave: String, home: () -> Unit) {
        if (_cargando.value == false) {
            _cargando.value == true
            auth.createUserWithEmailAndPassword(email, clave).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    home()
                } else {
                    Log.d("BillerBacon", "registrarUsuario: ${task.result.toString()}")
                }
                _cargando.value == false
            }
        }
    }
}