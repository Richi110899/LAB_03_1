package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add

class Scaffold : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScaffoldExample() // Configura el contenido de la actividad con el ejemplo de Scaffold
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldExample() {
    var presses by remember { mutableIntStateOf(0) } // Estado para contar clics del botón flotante

    Scaffold(
        topBar = { // Barra superior de la interfaz
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer, // Color de fondo de la barra
                    titleContentColor = MaterialTheme.colorScheme.primary, // Color del texto del título
                ),
                title = {
                    Text("Top app bar") // Título de la barra superior
                }
            )
        },
        bottomBar = { // Barra inferior de la interfaz
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer, // Color de fondo de la barra
                contentColor = MaterialTheme.colorScheme.primary, // Color del texto en la barra
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(), // Asegura que el texto ocupe el ancho completo de la barra
                    textAlign = TextAlign.Center, // Centra el texto
                    text = "Bottom app bar", // Texto de la barra inferior
                )
            }
        },
        floatingActionButton = { // Botón flotante de acción
            FloatingActionButton(onClick = { presses++ }) { // Incrementa el contador al hacer clic
                Icon(Icons.Default.Add, contentDescription = "Add") // Ícono del botón flotante
            }
        }
    ) { innerPadding -> // Contenido principal, ajustado por el relleno interno del Scaffold
        Column(
            modifier = Modifier
                .padding(innerPadding), // Aplica relleno interno para ajustar el contenido alrededor de las barras
            verticalArrangement = Arrangement.spacedBy(16.dp), // Espacio vertical entre los elementos
        ) {
            Text(
                modifier = Modifier.padding(8.dp), // Padding alrededor del texto
                text = "Este es un curso de Programación móvil en Tecsup 2024".trimIndent(), // Contenido del texto
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScaffoldPreview() {
    ScaffoldExample() // Vista previa del diseño del Scaffold
}
