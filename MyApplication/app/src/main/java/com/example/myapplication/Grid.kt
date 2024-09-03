package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Grid : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(), // Rellena toda la pantalla
                color = MaterialTheme.colorScheme.background // Fondo de la superficie
            ) {
                CenteredGrid() // Muestra la cuadrícula centrada
            }
        }
    }
}

@Composable
fun CenteredGrid() {

    val itemsList = List(9) { "Item ${it + 1}" } // Lista de elementos

    LazyVerticalGrid(
        columns = GridCells.Fixed(3), // Define 3 columnas en la cuadrícula
        modifier = Modifier
            .fillMaxSize() // Rellena el tamaño disponible
            .padding(16.dp), // Padding externo de la cuadrícula
        contentPadding = PaddingValues(8.dp), // Padding interno de los elementos
        verticalArrangement = Arrangement.spacedBy(8.dp), // Espacio entre filas
        horizontalArrangement = Arrangement.spacedBy(8.dp) // Espacio entre columnas
    ) {
        items(itemsList.size) { index ->
            val item = itemsList[index]
            Box(
                modifier = Modifier
                    .padding(8.dp) // Padding del elemento
                    .size(100.dp) // Tamaño fijo del elemento
                    .wrapContentSize(Alignment.Center) // Centra el contenido del Box
            ) {
                Text(
                    text = item, // Texto del elemento
                    fontSize = 20.sp, // Tamaño de la fuente
                    modifier = Modifier.align(Alignment.Center) // Centra el texto en el Box
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GridPreview() {
    CenteredGrid() // Vista previa de la cuadrícula
}
