package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class Card : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Configura el contenido de la actividad con el ejemplo de Card
        setContent {
            CardExample()
        }
    }
}

@Composable
fun CardExample() {
    Column(
        modifier = Modifier
            .padding(16.dp) // Espaciado externo de la columna
            .fillMaxSize() // Ocupa el tamaño máximo disponible
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth() // Ocupa el ancho completo disponible
                .padding(8.dp), // Espaciado externo de la tarjeta
            elevation = 8.dp, // Sombra y profundidad de la tarjeta
            backgroundColor = Color.LightGray // Color de fondo de la tarjeta
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp) // Espaciado interno de la tarjeta
                    .fillMaxWidth() // Ocupa el ancho completo disponible
            ) {
                Text(
                    text = "Card Title", // Título de la tarjeta
                    style = MaterialTheme.typography.h6, // Estilo del texto
                    color = Color.Black // Color del texto
                )
                Spacer(modifier = Modifier.height(8.dp)) // Espaciado vertical entre elementos
                Text(
                    text = "This is some content inside the card. It can include text, images, and other elements.", // Contenido de la tarjeta
                    style = MaterialTheme.typography.body1, // Estilo del texto
                    color = Color.Black // Color del texto
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardPreview() {
    // Vista previa del ejemplo de Card
    CardExample()
}
