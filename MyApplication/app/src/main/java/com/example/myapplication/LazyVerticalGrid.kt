package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class LazyVerticalGrid : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Llama a la función composable LazyVerticalGridExample para mostrar la UI
            LazyVerticalGridExample()
        }
    }
}

@Composable
fun LazyVerticalGridExample() {
    // Lista de 20 elementos de ejemplo
    val items = List(20) { "Item $it" }

    // Componente LazyVerticalGrid que crea una cuadrícula de elementos
    LazyVerticalGrid(
        columns = GridCells.Fixed(3), // Configura la cuadrícula para tener 3 columnas fijas
        modifier = Modifier
            .fillMaxSize() // Ocupa todo el espacio disponible
            .padding(8.dp) // Agrega un relleno de 8 dp alrededor de la cuadrícula
    ) {
        // Itera sobre los elementos de la lista y los coloca en la cuadrícula
        items(items) { item ->
            Box(
                modifier = Modifier
                    .padding(4.dp) // Agrega un relleno de 4 dp alrededor de cada elemento
                    .background(Color.Gray) // Establece un fondo gris para cada elemento
                    .fillMaxSize() // Asegura que el elemento llene el tamaño disponible
                    .aspectRatio(1f), // Mantiene una relación de aspecto 1:1 (cuadrado)
                contentAlignment = Alignment.Center // Centra el contenido dentro del Box
            ) {
                // Muestra el texto del ítem en color blanco
                Text(text = item, color = Color.White)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LazyVerticalGridPreview() {
    // Previsualiza la interfaz de usuario de LazyVerticalGridExample
    LazyVerticalGridExample()
}
