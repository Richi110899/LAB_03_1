package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class SanckBar : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Configura la interfaz de usuario utilizando SnackbarExample
            SnackbarExample()
        }
    }
}

@Composable
fun SnackbarExample() {
    // Crea un estado para el SnackbarHost
    val snackbarHostState = remember { SnackbarHostState() }
    // Estado para gestionar el mensaje del Snackbar
    var snackbarMessage by remember { mutableStateOf<String?>(null) }

    Scaffold(
        // Configura el SnackbarHost en el Scaffold
        snackbarHost = { SnackbarHost(snackbarHostState) },
        // Configura el FloatingActionButton (FAB)
        floatingActionButton = {
            FloatingActionButton(onClick = {
                // Establece el mensaje del Snackbar al hacer clic en el FAB
                snackbarMessage = "This is a Snackbar message"
            }) {
                // Icono para el FAB
                Icon(Icons.Filled.Add, contentDescription = "Show Snackbar")
            }
        },
        content = { innerPadding ->
            // Contenido principal de la pantalla
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(16.dp)
            ) {
                Text("Press the FAB to show a Snackbar")
            }
        }
    )

    // Efecto lanzado para mostrar el Snackbar cuando se actualiza el mensaje
    LaunchedEffect(snackbarMessage) {
        snackbarMessage?.let {
            snackbarHostState.showSnackbar(it)
            // Restablece el mensaje después de mostrar el Snackbar
            snackbarMessage = null
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SnackbarPreview() {
    // Previsualiza el componente SnackbarExample
    SnackbarExample()
}
