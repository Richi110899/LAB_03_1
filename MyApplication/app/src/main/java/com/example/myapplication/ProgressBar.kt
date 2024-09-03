package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ProgressBar : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LinearProgressBarExample()
        }
    }
}

@Composable
fun LinearProgressBarExample() {
    var progress by remember { mutableStateOf(0f) }  // Estado para el progreso de la barra
    val coroutineScope = rememberCoroutineScope()  // Alcance de las corutinas para actualizar el progreso

    // Efecto lanzado al inicio que actualiza el progreso de la barra
    LaunchedEffect(Unit) {
        coroutineScope.launch {
            while (progress < 1f) {  // Aumenta el progreso hasta el 100%
                delay(100)  // Espera 100 ms
                progress += 0.01f  // Incrementa el progreso
                if (progress > 1f) progress = 1f  // Limita el progreso al 100%
            }
        }
    }

    // Define el color de la barra basado en el progreso
    val progressColor = when {
        progress < 0.5f -> Color.Red
        progress < 1f -> Color.Yellow
        else -> Color.Green
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LinearProgressIndicator(
            progress = progress,
            color = progressColor,
            modifier = Modifier
                .fillMaxWidth()  // Ajusta el ancho al contenedor
                .height(10.dp)  // Altura fija de la barra
        )
        Spacer(modifier = Modifier.height(16.dp))  // Espacio entre la barra y el texto
        Text(
            text = "Progreso: ${(progress * 100).toInt()}%",  // Muestra el porcentaje de progreso
            style = MaterialTheme.typography.titleLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LinearProgressBarPreview() {
    LinearProgressBarExample()
}
