package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource

class Image : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Configura el contenido de la actividad con el ejemplo de Image
        setContent {
            ImageExample()
        }
    }
}

@Composable
fun ImageExample() {
    // Carga la imagen desde los recursos utilizando su ID
    val image: Painter = painterResource(id = R.drawable.img)

    Box(
        modifier = Modifier
            .fillMaxSize() // Ocupa el tamaño completo disponible de la pantalla
            .padding(16.dp), // Aplica un relleno alrededor del contenido
        contentAlignment = Alignment.Center // Centra el contenido en el box
    ) {
        Image(
            painter = image, // Imagen cargada desde los recursos
            contentDescription = "Sample Image", // Descripción del contenido para accesibilidad
            modifier = Modifier
                .size(200.dp) // Tamaño fijo de la imagen
                .fillMaxWidth() // Ajusta la imagen al ancho máximo disponible
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ImagePreview() {
    // Vista previa del ejemplo de Image
    ImageExample()
}

