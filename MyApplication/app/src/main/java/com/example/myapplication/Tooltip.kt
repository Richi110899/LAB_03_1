package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.clickable
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TooltipExample()
        }
    }
}

@Composable
fun TooltipExample() {
    // Estado para controlar la visibilidad del tooltip
    var showTooltip by remember { mutableStateOf(false) }

    // Contenedor Box para la disposición del contenido
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Botón que alterna la visibilidad del tooltip
        Button(
            onClick = { showTooltip = !showTooltip },
            modifier = Modifier.align(Alignment.Center)
        ) {
            Text("Mostrar Tooltip")
        }

        // Mostrar el tooltip condicionalmente basado en el estado
        if (showTooltip) {
            Box(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(16.dp)
                    .background(Color.Gray) // Color de fondo del tooltip
                    .padding(8.dp)
                    .clickable { showTooltip = false } // Ocultar el tooltip al hacer clic
            ) {
                Text(
                    text = "Información adicional",
                    color = Color.White,
                    fontSize = 14.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TooltipPreview() {
    TooltipExample()
}
