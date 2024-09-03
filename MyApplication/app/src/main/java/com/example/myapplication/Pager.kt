package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.*

class Pager : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Llama a la función composable PagerExample para mostrar la UI
            PagerExample()
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun PagerExample() {
    // Crea y recuerda el estado del pager
    val pagerState = rememberPagerState()

    // Estructura de la interfaz de usuario con un pager horizontal
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Pager horizontal que permite la paginación de contenido
        HorizontalPager(
            count = 3,  // Número total de páginas
            state = pagerState  // Estado del pager para controlar la página actual
        ) { page ->
            // Contenido de cada página del pager
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text("Page $page")  // Muestra el número de la página actual
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PagerPreview() {
    // Previsualiza la interfaz de usuario de PagerExample
    PagerExample()
}
