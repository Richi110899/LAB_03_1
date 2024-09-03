package com.example.myapplication111

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Person

class BottomNavigation : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Llama a la función composable BottomNavigationExample para mostrar la UI
            BottomNavigationExample()
        }
    }
}

@Composable
fun BottomNavigationExample() {
    // Estado mutable para mantener el elemento de navegación seleccionado
    var selectedItem by remember { mutableStateOf("Home") }

    // Scaffold proporciona una estructura básica de diseño con una barra de navegación inferior
    Scaffold(
        bottomBar = {
            // Configura la barra de navegación inferior (NavigationBar)
            NavigationBar {
                // Elemento de navegación para "Home"
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.Home, contentDescription = "Home") },
                    label = { Text("Home") },
                    selected = selectedItem == "Home",
                    onClick = { selectedItem = "Home" }
                )
                // Elemento de navegación para "Search"
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.Search, contentDescription = "Search") },
                    label = { Text("Search") },
                    selected = selectedItem == "Search",
                    onClick = { selectedItem = "Search" }
                )
                // Elemento de navegación para "Profile"
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.Person, contentDescription = "Profile") },
                    label = { Text("Profile") },
                    selected = selectedItem == "Profile",
                    onClick = { selectedItem = "Profile" }
                )
            }
        }
    ) { innerPadding ->
        // Contenido principal de la aplicación ajustado por el padding de la barra inferior
        Box(
            modifier = Modifier
                .padding(innerPadding) // Aplica padding para evitar que el contenido quede cubierto por la barra inferior
                .fillMaxSize()
        ) {
            // Muestra el contenido basado en el elemento de navegación seleccionado
            when (selectedItem) {
                "Home" -> Text("Home Screen", modifier = Modifier.padding(16.dp))
                "Search" -> Text("Search Screen", modifier = Modifier.padding(16.dp))
                "Profile" -> Text("Profile Screen", modifier = Modifier.padding(16.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationPreview() {
    // Previsualiza la interfaz de usuario de BottomNavigationExample
    BottomNavigationExample()
}
