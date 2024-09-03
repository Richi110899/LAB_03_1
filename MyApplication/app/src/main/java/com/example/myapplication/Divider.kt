package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class Divider : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DividerExample()
        }
    }
}

@Composable
fun DividerExample() {
    Column(
        modifier = Modifier
            .fillMaxSize() // Ocupa todo el espacio disponible
            .padding(16.dp), // Agrega un relleno de 16 dp alrededor del contenido
        verticalArrangement = Arrangement.spacedBy(16.dp) // Espacia los elementos verticalmente
    ) {
        Text("Item 1")
        Divider(
            color = Color.Gray, // Color personalizado
            thickness = 2.dp // Grosor personalizado
        )
        Text("Item 2")
        Divider(
            color = Color.Gray, // Color personalizado
            thickness = 2.dp // Grosor personalizado
        )
        Text("Item 3")
    }
}

@Preview(showBackground = true)
@Composable
fun DividerPreview() {
    DividerExample()
}
