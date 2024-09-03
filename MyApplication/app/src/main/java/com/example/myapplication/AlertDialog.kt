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

class AlertDialog : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlertDialogExample()
        }
    }
}

@Composable
fun AlertDialogExample() {
    // Estado para controlar la visibilidad del AlertDialog
    var showDialog by remember { mutableStateOf(false) }

    // Botón para mostrar el AlertDialog
    Button(onClick = { showDialog = true }) {
        Text("Show Alert Dialog")
    }

    // Mostrar el AlertDialog si showDialog es verdadero
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false }, // Acción cuando el diálogo es descartado (clic fuera o back)
            title = { Text(text = "Alert Dialog Title") }, // Título del diálogo
            text = { Text("This is the content of the AlertDialog.") }, // Contenido del diálogo
            confirmButton = {
                Button(onClick = { showDialog = false }) { // Botón para confirmar la acción
                    Text("OK")
                }
            },
            dismissButton = {
                OutlinedButton(onClick = { showDialog = false }) { // Botón para cancelar la acción
                    Text("Cancel")
                }
            },
            modifier = Modifier.padding(16.dp) // Padding alrededor del diálogo
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AlertDialogPreview() {
    AlertDialogExample()
}
