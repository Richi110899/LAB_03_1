package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

class BackdropScaffold : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Configura el contenido de la actividad con el ejemplo de BackdropScaffold
            BackdropScaffoldExample()
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BackdropScaffoldExample() {
    // Estado y ámbito de corutina para manejar la visibilidad de las capas
    val scaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed)
    val scope = rememberCoroutineScope()

    BackdropScaffold(
        scaffoldState = scaffoldState, // Estado que controla la visibilidad de las capas
        appBar = {
            TopAppBar(
                title = { Text("BackdropScaffold Example") }, // Título del app bar
                backgroundColor = Color.Blue, // Color de fondo del app bar
                contentColor = Color.White // Color del contenido del app bar
            )
        },
        backLayerContent = {
            // Contenido de la capa trasera
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Text("Back Layer Content")
                Button(onClick = {
                    // Revela la capa delantera al hacer clic
                    scope.launch { scaffoldState.reveal() }
                }) {
                    Text("Reveal Front Layer")
                }
            }
        },
        frontLayerContent = {
            // Contenido de la capa delantera
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Text("Front Layer Content")
                Button(onClick = {
                    // Oculta la capa delantera al hacer clic
                    scope.launch { scaffoldState.conceal() }
                }) {
                    Text("Conceal Front Layer")
                }
            }
        },
        peekHeight = 60.dp, // Altura de la parte visible de la capa delantera
        headerHeight = 60.dp, // Altura del encabezado del app bar
        gesturesEnabled = true // Habilita interacciones táctiles
    )
}

@Preview(showBackground = true)
@Composable
fun BackdropScaffoldPreview() {
    // Vista previa del BackdropScaffold
    BackdropScaffoldExample()
}
