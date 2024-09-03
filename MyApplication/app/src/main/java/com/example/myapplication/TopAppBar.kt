package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class TopAppBar : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Llama a la función composable TopAppBarExample para mostrar la UI
            TopAppBarExample()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarExample() {
    // Estado mutable que cuenta la cantidad de presiones (no utilizado en este ejemplo)
    var presses by remember { mutableIntStateOf(0) }

    // Scaffold es un contenedor para colocar la AppBar y el contenido principal
    Scaffold(
        topBar = {
            // Configura la barra superior de la aplicación (TopAppBar)
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer, // Color de fondo
                    titleContentColor = MaterialTheme.colorScheme.primary, // Color del texto del título
                ),
                title = {
                    // Título de la barra superior
                    Text("Top app bar")
                }
            )
        },
    ) { innerPadding ->
        // Contenido principal de la aplicación, ajustado por el padding de la barra superior
        Column(
            modifier = Modifier
                .padding(innerPadding), // Aplica padding para evitar que el contenido quede cubierto por la barra superior
            verticalArrangement = Arrangement.spacedBy(16.dp), // Espacio vertical entre elementos
        ) {
            // Texto dentro del contenido principal
            Text(
                modifier = Modifier.padding(8.dp), // Aplica padding alrededor del texto
                text = "Este es un curso de Programación móvil en Tecsup 2024".trimIndent(),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TopAppBarPreview() {
    // Previsualiza la interfaz de usuario de TopAppBarExample
    TopAppBarExample()
}
