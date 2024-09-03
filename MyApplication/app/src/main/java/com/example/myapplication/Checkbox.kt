package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class Checkbox : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Configura el contenido de la actividad con el ejemplo de Checkbox
        setContent {
            CheckboxExample()
        }
    }
}

@Composable
fun CheckboxExample() {
    var checked by remember { mutableStateOf(false) } // Estado de la casilla de verificación

    Column(
        modifier = Modifier
            .padding(16.dp) // Espaciado externo de la columna
            .fillMaxSize() // Ocupa el tamaño máximo disponible
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically, // Alinea verticalmente el contenido
            modifier = Modifier.padding(8.dp) // Espaciado externo de la fila
        ) {
            Checkbox(
                checked = checked, // Estado actual de la casilla
                onCheckedChange = { newValue -> // Callback para cambiar el estado
                    checked = newValue
                }
            )
            Spacer(modifier = Modifier.width(8.dp)) // Espaciado horizontal entre la casilla y el texto
            Text(
                text = "Checkbox is ${if (checked) "checked" else "unchecked"}", // Texto que refleja el estado de la casilla
                style = MaterialTheme.typography.body1 // Estilo del texto
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CheckboxPreview() {
    // Vista previa del ejemplo de Checkbox
    CheckboxExample()
}
