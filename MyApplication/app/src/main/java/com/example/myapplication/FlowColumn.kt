package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowColumn
import androidx.compose.ui.tooling.preview.Preview

class FlowColumn : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FlowColumnExample()
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FlowColumnExample() {
    val items = List(20) { "Item ${it + 1}" }

    FlowColumn(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        mainAxisSpacing = 8.dp,
        crossAxisSpacing = 8.dp
    ) {
        items.forEach { item ->
            Chip(
                onClick = { /* Handle click */ },
                modifier = Modifier.padding(4.dp)
            ) {
                Text(text = item)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FlowColumnPreview() {
    FlowColumnExample()
}

