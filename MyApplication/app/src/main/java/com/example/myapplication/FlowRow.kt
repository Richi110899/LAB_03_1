package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowRow
import androidx.compose.ui.tooling.preview.Preview

class FlowRow : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Configura el contenido de la actividad con el ejemplo de FlowRow
        setContent {
            FlowRowExample()
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FlowRowExample() {
    // Lista de ítems para mostrar en la fila
    val items = List(15) { "Item ${it + 1}" }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), // Espaciado general de la columna
        horizontalAlignment = Alignment.CenterHorizontally // Centra el contenido horizontalmente
    ) {
        FlowRow(
            modifier = Modifier
                .fillMaxWidth() // Ocupa el ancho completo
                .wrapContentHeight(), // Ajusta la altura al contenido
            mainAxisSpacing = 8.dp, // Espaciado entre elementos en la dirección principal
            crossAxisSpacing = 8.dp // Espaciado entre filas en la dirección cruzada
        ) {
            // Itera sobre la lista de ítems y crea un chip para cada uno
            for (item in items) {
                Chip(
                    onClick = { /* Manejar clic */ },
                    modifier = Modifier.padding(4.dp) // Espaciado individual de cada chip
                ) {
                    Text(text = item) // Texto del chip
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FlowRowPreview() {
    // Vista previa del FlowRow
    FlowRowExample()
}
