package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class Switch : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Llama a la función composable SwitchExample para mostrar su UI
            SwitchExample()
        }
    }
}

@Composable
fun SwitchExample() {
    // Estado mutable que controla si el Switch está encendido o apagado
    var switchState by remember { mutableStateOf(false) }

    // Columna que organiza los elementos verticalmente
    Column(modifier = Modifier.padding(16.dp)) {
        // Fila que contiene el texto y el Switch
        Row(verticalAlignment = Alignment.CenterVertically) {
            // Texto que muestra el estado actual del Switch
            Text("Switch is ${if (switchState) "On" else "Off"}", style = MaterialTheme.typography.bodyLarge)
            // Espacio entre el texto y el Switch
            Spacer(modifier = Modifier.width(16.dp))
            // Componente Switch que permite alternar entre los estados
            Switch(
                checked = switchState, // Estado actual del Switch
                onCheckedChange = { switchState = it } // Actualiza el estado cuando cambia
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SwitchPreview() {
    // Previsualiza la interfaz de usuario de SwitchExample
    SwitchExample()
}
