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

class TabRow : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Configura la interfaz de usuario utilizando TabRowExample
            TabRowExample()
        }
    }
}

@Composable
fun TabRowExample() {
    // Estado para mantener el índice de la pestaña seleccionada
    var selectedTabIndex by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            // Configura la TabRow en la parte superior
            TabRow(
                selectedTabIndex = selectedTabIndex,
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            ) {
                // Pestaña 1
                Tab(
                    selected = selectedTabIndex == 0,
                    onClick = { selectedTabIndex = 0 },
                    text = { Text("Tab 1") }
                )
                // Pestaña 2
                Tab(
                    selected = selectedTabIndex == 1,
                    onClick = { selectedTabIndex = 1 },
                    text = { Text("Tab 2") }
                )
                // Pestaña 3
                Tab(
                    selected = selectedTabIndex == 2,
                    onClick = { selectedTabIndex = 2 },
                    text = { Text("Tab 3") }
                )
            }
        },
        content = { innerPadding ->
            // Muestra el contenido de la pestaña seleccionada
            when (selectedTabIndex) {
                0 -> TabContent("Content for Tab 1", innerPadding)
                1 -> TabContent("Content for Tab 2", innerPadding)
                2 -> TabContent("Content for Tab 3", innerPadding)
            }
        }
    )
}

@Composable
fun TabContent(content: String, innerPadding: PaddingValues) {
    // Configura el contenido de la pestaña con el texto dado y aplica relleno
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(16.dp)
    ) {
        Text(text = content)
    }
}

@Preview(showBackground = true)
@Composable
fun TabRowPreview() {
    // Previsualiza el componente TabRowExample
    TabRowExample()
}
