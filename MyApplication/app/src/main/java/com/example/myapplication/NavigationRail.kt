package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*

class NavigationRail : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Llama a la función composable NavigationRailExample para mostrar la UI
            NavigationRailExample()
        }
    }
}

@Composable
fun NavigationRailExample() {
    // Estado para rastrear el ítem seleccionado
    var selectedItem by remember { mutableStateOf(0) }

    // Scaffold que organiza la estructura básica de la pantalla
    Scaffold(
        // Barra de navegación lateral (NavigationRail)
        bottomBar = {
            NavigationRail {
                // Primer ítem de la barra de navegación
                NavigationRailItem(
                    icon = { Icon(Icons.Filled.Home, contentDescription = "Home") },
                    label = { Text("Home") },
                    selected = selectedItem == 0,
                    onClick = { selectedItem = 0 }
                )
                // Segundo ítem de la barra de navegación
                NavigationRailItem(
                    icon = { Icon(Icons.Filled.Search, contentDescription = "Search") },
                    label = { Text("Search") },
                    selected = selectedItem == 1,
                    onClick = { selectedItem = 1 }
                )
                // Tercer ítem de la barra de navegación
                NavigationRailItem(
                    icon = { Icon(Icons.Filled.Settings, contentDescription = "Settings") },
                    label = { Text("Settings") },
                    selected = selectedItem == 2,
                    onClick = { selectedItem = 2 }
                )
            }
        }
    ) { innerPadding ->
        // Contenido de la pantalla que se ajusta al espacio disponible
        Box(modifier = Modifier.padding(innerPadding)) {
            // Muestra el ítem seleccionado en un texto
            Text("Selected item: $selectedItem")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NavigationRailPreview() {
    // Previsualiza la interfaz de usuario de NavigationRailExample
    NavigationRailExample()
}
