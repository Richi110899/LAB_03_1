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

class Dialog : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Llama a la función composable DialogExample para mostrar la UI
            DialogExample()
        }
    }
}

@Composable
fun DialogExample() {
    // Estado mutable para controlar la visibilidad del diálogo
    var showDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        // Botón para mostrar el diálogo
        Button(onClick = { showDialog = true }) {
            Text("Show Dialog")
        }

        // Muestra el diálogo cuando showDialog es verdadero
        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false }, // Cierra el diálogo al hacer clic fuera de él
                title = { Text("Dialog Title") }, // Título del diálogo
                text = { Text("This is a dialog message.") }, // Mensaje del diálogo
                confirmButton = {
                    // Botón de confirmación para cerrar el diálogo
                    TextButton(onClick = { showDialog = false }) {
                        Text("OK")
                    }
                },
                dismissButton = {
                    // Botón para cancelar y cerrar el diálogo
                    TextButton(onClick = { showDialog = false }) {
                        Text("Cancel")
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DialogPreview() {
    // Previsualiza la interfaz de usuario de DialogExample
    DialogExample()
}
