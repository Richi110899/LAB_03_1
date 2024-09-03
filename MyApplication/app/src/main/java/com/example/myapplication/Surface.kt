package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape

class Surface : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SurfaceExample() // Configura el contenido de la actividad con el ejemplo de Surface
        }
    }
}

@Composable
fun SurfaceExample() {
    Surface(
        modifier = Modifier
            .padding(16.dp) // Padding alrededor del Surface
            .border(1.dp, Color.Gray, RoundedCornerShape(8.dp)), // Borde gris con esquinas redondeadas
        color = MaterialTheme.colorScheme.surface, // Color de fondo del Surface
        contentColor = MaterialTheme.colorScheme.onSurface, // Color del contenido dentro del Surface
        shadowElevation = 8.dp, // Sombra de elevación para dar profundidad
        shape = MaterialTheme.shapes.medium // Forma del Surface usando los estilos del tema
    ) {
        Text(
            text = "Hello, Surface!", // Texto mostrado dentro del Surface
            modifier = Modifier.padding(16.dp) // Padding interno del texto
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SurfacePreview() {
    SurfaceExample() // Vista previa del diseño del Surface
}
