package com.example.billerbacon.interfaces.main

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaInformacion() {
    val currentDate = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(Date())
    Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.CenterEnd) {
                            Text(text = currentDate, color = Color.Black)
                        }
                    },
                    navigationIcon = {
                        IconButton(onClick = { /* handle navigation icon click */ }) {
                            Icon(Icons.Filled.Menu, contentDescription = "Menu", tint = Color.Black)
                        }
                    },
                    colors = TopAppBarDefaults.smallTopAppBarColors(
                        containerColor = Color(0xFFffe8c0)
                    )
                )
            }
    ) { paddingValues ->
        Column(modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFffe8c0))
            .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(modifier = Modifier
                .background(Color.White, shape = RoundedCornerShape(25.dp))
                .width(350.dp)
                .height(500.dp)
                .padding(10.dp)
            ) {
                Column(Modifier.fillMaxWidth().fillMaxHeight()) {
                    Row(horizontalArrangement = Arrangement.SpaceAround,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Box() {
                            Text(text = "Netflix")
                        }
                        Column(horizontalAlignment = Alignment.End) {
                            Text(text = "Precio Actual", fontSize = 20.sp)
                            Text(text = "12.99€", fontSize = 20.sp)
                        }
                    }
                    Spacer(modifier = Modifier.height(50.dp))
                    Box(Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier
                            .background(Color.LightGray, shape = RoundedCornerShape(25.dp))
                            .fillMaxWidth()
                            .padding(20.dp)
                        ) {
                            GenerarEstructuraFacturacion(texto1 = "Próxima Factura", texto2 = "12.99€")
                            Spacer(modifier = Modifier.height(10.dp))
                            GenerarEstructuraFacturacion(texto1 = "Fecha", texto2 = "23-11-2024")
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Box(Modifier.fillMaxWidth().fillMaxHeight()
                    ) {
                        Column(modifier = Modifier
                            .background(Color(0xFFFFE587), shape = RoundedCornerShape(25.dp))
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .padding(20.dp)
                        ) {
                            for (i in 1..6) {
                                GenerarEstructuraFacturacion(texto1 = "23-12-2024", texto2 = "12.99€")
                                Spacer(modifier = Modifier.height(10.dp))
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun GenerarEstructuraFacturacion(texto1: String, texto2: String) {
    Row(horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = texto1, fontSize = 20.sp)
        Text(text = texto2, fontSize = 20.sp)
    }
}

@Preview
@Composable
fun Preview() {
    PantallaInformacion()
}