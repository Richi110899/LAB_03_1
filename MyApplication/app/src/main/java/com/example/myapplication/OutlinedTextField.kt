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

class OutlinedTextField : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Llama a la función composable OutlinedTextFieldExample para mostrar la UI
            OutlinedTextFieldExample()
        }
    }
}

@Composable
fun OutlinedTextFieldExample() {
    // Estado para almacenar el texto ingresado en el campo de texto
    var text by remember { mutableStateOf("") }

    // Estructura de la interfaz de usuario con un campo de texto y espaciado
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Campo de texto con borde
        OutlinedTextField(
            value = text,  // Valor actual del campo de texto
            onValueChange = { text = it },  // Actualiza el estado cuando el texto cambia
            label = { Text("Enter text") },  // Etiqueta del campo de texto
            modifier = Modifier.fillMaxWidth()  // Ocupa todo el ancho disponible
        )
    }
}

@Preview(showBackground = true)
@Composable
fun OutlinedTextFieldPreview() {
    // Previsualiza la interfaz de usuario de OutlinedTextFieldExample
    OutlinedTextFieldExample()
}
