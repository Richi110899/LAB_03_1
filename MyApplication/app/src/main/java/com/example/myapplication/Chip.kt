package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Close

class Chip : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Configura el contenido de la actividad con el ejemplo de InputChip
            InputChipExample(
                text = "Input Chip", // Texto mostrado en el chip
                onDismiss = { Log.d("InputChipExample", "Chip dismissed") } // Acción al cerrar el chip
            )
        }
    }
}

@Composable
fun InputChipExample(
    text: String, // Texto a mostrar en el chip
    onDismiss: () -> Unit, // Acción a realizar al cerrar el chip
) {
    var enabled by remember { mutableStateOf(true) } // Estado que controla si el chip está habilitado

    if (!enabled) return // No renderiza el chip si está deshabilitado

    InputChip(
        onClick = {
            onDismiss() // Llama a la acción onDismiss
            enabled = !enabled // Alterna el estado habilitado del chip
        },
        label = { Text(text) }, // Texto del chip
        selected = enabled, // Marca el chip como seleccionado si está habilitado
        avatar = {
            Icon(
                Icons.Filled.Person, // Ícono de avatar
                contentDescription = "Avatar", // Descripción del contenido para accesibilidad
                modifier = Modifier.size(24.dp) // Tamaño del ícono
            )
        },
        trailingIcon = {
            Icon(
                Icons.Filled.Close, // Ícono de cierre
                contentDescription = "Close", // Descripción del contenido para accesibilidad
                modifier = Modifier.size(24.dp) // Tamaño del ícono
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
fun ChipPreview() {
    // Vista previa del InputChip con una acción no operativa
    InputChipExample(
        text = "Input Chip",
        onDismiss = { /* No-op */ }
    )
}
