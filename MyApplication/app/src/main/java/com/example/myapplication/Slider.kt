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

class Slider : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SliderExample()
        }
    }
}

@Composable
fun SliderExample() {
    // Estado mutable para almacenar la posición actual del slider.
    var sliderPosition by remember { mutableStateOf(0f) }

    // Column que organiza el contenido verticalmente.
    Column(modifier = Modifier.padding(16.dp)) {
        // Texto que muestra el valor actual del slider.
        Text("Slider value: ${sliderPosition.toInt()}", style = MaterialTheme.typography.bodyLarge)

        // Espaciador entre el texto y el slider.
        Spacer(modifier = Modifier.height(16.dp))

        // Componente Slider que permite al usuario seleccionar un valor dentro de un rango.
        Slider(
            value = sliderPosition, // Valor actual del slider.
            onValueChange = { sliderPosition = it }, // Actualiza el valor del slider cuando cambia.
            valueRange = 0f..100f // Rango de valores del slider, de 0 a 100.
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SliderPreview() {
    SliderExample()
}
