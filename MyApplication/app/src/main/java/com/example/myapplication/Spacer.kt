package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class Spacer : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpacerExample()
        }
    }
}

@Composable
fun SpacerExample() {
    // Column que organiza los elementos verticalmente y tiene relleno de 16 dp en los bordes.
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        // Row que organiza los elementos horizontalmente con relleno inferior de 16 dp.
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Botón con texto.
            Button(onClick = { /* Handle click */ }) {
                Text("Button")
            }
            // Espaciador horizontal de 16 dp entre el botón y el texto.
            Spacer(modifier = Modifier.width(16.dp))
            // Texto colocado al lado del botón.
            Text("This is some text next to the button.")
        }

        // Espaciador vertical de 32 dp entre el primer Row y la columna siguiente.
        Spacer(modifier = Modifier.height(32.dp))

        // Column que organiza los textos verticalmente.
        Column {
            // Primer línea de texto.
            Text("First line of text")
            // Espaciador vertical de 16 dp entre las líneas de texto.
            Spacer(modifier = Modifier.height(16.dp))
            // Segunda línea de texto.
            Text("Second line of text")
            // Espaciador vertical de 16 dp entre las líneas de texto.
            Spacer(modifier = Modifier.height(16.dp))
            // Tercera línea de texto.
            Text("Third line of text")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SpacerPreview() {
    SpacerExample()
}
