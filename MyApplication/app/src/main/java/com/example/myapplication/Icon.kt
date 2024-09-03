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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.unit.dp

class Icon : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Configura el contenido de la actividad con el ejemplo de Icon
        setContent {
            IconExample()
        }
    }
}

@Composable
fun IconExample() {
    Column(
        modifier = Modifier
            .fillMaxSize() // Ocupa el tamaño completo disponible de la pantalla
            .padding(16.dp), // Aplica un relleno alrededor del contenido
        verticalArrangement = Arrangement.Center, // Centra el contenido verticalmente
        horizontalAlignment = Alignment.CenterHorizontally // Centra el contenido horizontalmente
    ) {
        Icon(
            imageVector = Icons.Filled.Person, // Icono de una persona del paquete de íconos prediseñados
            contentDescription = "Person Icon", // Descripción del contenido para accesibilidad
            tint = MaterialTheme.colorScheme.primary, // Color de tinte del icono, ajustado al esquema de colores primarios
            modifier = Modifier.size(48.dp) // Tamaño del icono
        )
    }
}

@Preview(showBackground = true)
@Composable
fun IconPreview() {
    // Vista previa del ejemplo de Icon
    IconExample()
}
