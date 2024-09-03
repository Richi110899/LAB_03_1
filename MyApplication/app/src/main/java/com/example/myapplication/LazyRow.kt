package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class LazyRow : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                CenteredLazyRow() // Llama al composable que contiene LazyRow
            }
        }
    }
}

@Composable
fun CenteredLazyRow() {
    // Crea una lista de elementos de ejemplo
    val itemsList = List(100) { "Item ${it + 1}" }.take(3)

    // LazyRow para mostrar una lista horizontal desplazable
    LazyRow(
        modifier = Modifier
            .fillMaxWidth() // Ocupa todo el ancho disponible
            .padding(16.dp), // Añade relleno alrededor de la fila
        horizontalArrangement = Arrangement.Center, // Centra los elementos horizontalmente
        verticalAlignment = Alignment.CenterVertically // Alinea los elementos verticalmente en el centro
    ) {
        items(itemsList) { item ->
            Box(
                modifier = Modifier
                    .padding(8.dp) // Añade relleno entre los elementos
                    .widthIn(min = 100.dp) // Ancho mínimo para cada elemento
                    .height(50.dp) // Altura fija para cada elemento
                    .wrapContentSize(Alignment.Center) // Centra el contenido dentro del Box
            ) {
                Text(
                    text = item,
                    fontSize = 20.sp, // Tamaño de fuente para el texto
                    modifier = Modifier.align(Alignment.Center) // Centra el texto dentro del Box
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LazyRowPreview() {
    CenteredLazyRow() // Previsualiza el composable en el editor
}
