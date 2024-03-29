package com.example.billerbacon.navegacion

sealed class Navegacion(val ruta: String) {
    object PantallaBienvenida: Navegacion("PantallaBienvenida")
    object PantallaIniciarSesion: Navegacion("PantallaIniciarSesion")
    object PantallaRegistro: Navegacion("PantallaRegistro")
    object PantallaInicio: Navegacion("PantallaInicio")
    object PantallaInformacion: Navegacion("PantallaInformacion")
    object PantallaCreditos: Navegacion("PantallaCreditos")
}