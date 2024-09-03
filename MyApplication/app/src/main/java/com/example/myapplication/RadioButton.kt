package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class RadioButton : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RadioButtonExample()
        }
    }
}

@Composable
fun RadioButtonExample() {
    // Estado para la opción seleccionada
    var selectedOption by remember { mutableStateOf("Option 1") }

    Column(modifier = Modifier.padding(16.dp)) {
        // Opciones del RadioButton
        Row(modifier = Modifier.padding(vertical = 8.dp)) {
            RadioButton(
                selected = (selectedOption == "Option 1"),  // Verifica si esta opción está seleccionada
                onClick = { selectedOption = "Option 1" }  // Actualiza la opción seleccionada
            )
            Spacer(modifier = Modifier.width(8.dp))  // Espacio entre el RadioButton y el texto
            Text("Option 1", modifier = Modifier.align(Alignment.CenterVertically))  // Texto de la opción
        }

        Row(modifier = Modifier.padding(vertical = 8.dp)) {
            RadioButton(
                selected = (selectedOption == "Option 2"),  // Verifica si esta opción está seleccionada
                onClick = { selectedOption = "Option 2" }  // Actualiza la opción seleccionada
            )
            Spacer(modifier = Modifier.width(8.dp))  // Espacio entre el RadioButton y el texto
            Text("Option 2", modifier = Modifier.align(Alignment.CenterVertically))  // Texto de la opción
        }

        Row(modifier = Modifier.padding(vertical = 8.dp)) {
            RadioButton(
                selected = (selectedOption == "Option 3"),  // Verifica si esta opción está seleccionada
                onClick = { selectedOption = "Option 3" }  // Actualiza la opción seleccionada
            )
            Spacer(modifier = Modifier.width(8.dp))  // Espacio entre el RadioButton y el texto
            Text("Option 3", modifier = Modifier.align(Alignment.CenterVertically))  // Texto de la opción
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RadioButtonPreview() {
    RadioButtonExample()
}
