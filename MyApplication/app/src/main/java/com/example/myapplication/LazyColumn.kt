package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Actividad principal de la aplicación
class LazyColumn : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Superficie de fondo para la aplicación
            Surface(
                modifier = Modifier.fillMaxSize(), // Ocupa todo el espacio disponible
                color = MaterialTheme.colorScheme.background // Usa el color de fondo del tema
            ) {
                SimpleLazyColumn() // Llama al composable que define la lista
            }
        }
    }
}

// Composable para mostrar una lista simple
@Composable
fun SimpleLazyColumn() {
    // Crea una lista de 5 elementos con texto "Item 1", "Item 2", etc.
    val itemsList = List(100) { "Item ${it + 1}" }.take(5)

    // LazyColumn para mostrar los elementos de forma eficiente
    LazyColumn(
        modifier = Modifier
            .fillMaxSize() // Expande para llenar todo el espacio disponible
            .padding(16.dp) // Agrega relleno alrededor del contenido
    ) {
        // Muestra cada elemento de itemsList
        items(itemsList) { item ->
            // Muestra cada item como un texto en la lista
            Text(
                text = item, // Texto del elemento
                fontSize = 20.sp, // Tamaño de la fuente
                modifier = Modifier.padding(8.dp) // Rellena alrededor del texto
            )
        }
    }
}

// Vista previa del composable
@Preview(showBackground = true)
@Composable
fun LazyColumnPreview() {
    SimpleLazyColumn() // Muestra la lista en la vista previa
}
