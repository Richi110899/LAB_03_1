package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add

class FloatingActionButtom : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Configura el contenido de la actividad con el ejemplo de FloatingActionButton
        setContent {
            FloatingActionButtonExample()
        }
    }
}

@Composable
fun FloatingActionButtonExample() {
    var count by remember { mutableStateOf(0) } // Estado para contar las pulsaciones

    Box(
        modifier = Modifier.fillMaxSize(), // Ocupa el tamaño completo disponible
        contentAlignment = Alignment.BottomEnd // Alinea el contenido en la esquina inferior derecha
    ) {
        FloatingActionButton(
            onClick = { count++ }, // Incrementa el contador al hacer clic
            containerColor = MaterialTheme.colorScheme.primary // Color del fondo del botón
        ) {
            Icon(
                imageVector = Icons.Filled.Add, // Icono de adición
                contentDescription = "Add" // Descripción del contenido para accesibilidad
            )
        }
        Text(
            text = "Count: $count", // Texto que muestra el valor del contador
            modifier = Modifier
                .padding(16.dp) // Espaciado alrededor del texto
                .align(Alignment.BottomStart) // Alinea el texto en la esquina inferior izquierda
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FloatingActionButtonPreview() {
    // Vista previa del ejemplo de FloatingActionButton
    FloatingActionButtonExample()
}
