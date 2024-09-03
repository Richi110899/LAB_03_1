package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

class DropDownMenu : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Llama a la función composable DropdownMenuExample para mostrar la UI
            DropdownMenuExample()
        }
    }
}

@Composable
fun DropdownMenuExample() {
    // Estado para controlar si el menú desplegable está expandido o colapsado
    var expanded by remember { mutableStateOf(false) }
    // Estado para guardar la opción seleccionada
    var selectedOption by remember { mutableStateOf("None") }

    Column(
        modifier = Modifier
            .fillMaxSize() // Ocupa todo el espacio disponible
            .padding(16.dp) // Agrega un relleno de 16 dp alrededor del contenido
    ) {
        // Muestra la opción seleccionada
        Text(
            text = "Selected Option: $selectedOption",
            style = TextStyle(
                fontSize = 20.sp, // Tamaño de fuente
                fontWeight = FontWeight.Bold // Peso de fuente
            )
        )

        Spacer(modifier = Modifier.height(16.dp)) // Espacio entre el texto y el botón

        // Botón que al hacer clic alterna la visibilidad del menú desplegable
        Button(onClick = { expanded = !expanded }) {
            Text("Show Menu")
        }

        // Menú desplegable
        DropdownMenu(
            expanded = expanded, // Controla la visibilidad del menú
            onDismissRequest = { expanded = false } // Cierra el menú cuando se hace clic fuera de él
        ) {
            // Elementos del menú desplegable
            DropdownMenuItem(onClick = {
                selectedOption = "Option 1" // Actualiza la opción seleccionada
                expanded = false // Cierra el menú
            }) {
                Text("Option 1")
            }
            DropdownMenuItem(onClick = {
                selectedOption = "Option 2" // Actualiza la opción seleccionada
                expanded = false // Cierra el menú
            }) {
                Text("Option 2")
            }
            DropdownMenuItem(onClick = {
                selectedOption = "Option 3" // Actualiza la opción seleccionada
                expanded = false // Cierra el menú
            }) {
                Text("Option 3")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DropDownMenuPreview() {
    // Previsualiza la interfaz de usuario de DropdownMenuExample
    DropdownMenuExample()
}
