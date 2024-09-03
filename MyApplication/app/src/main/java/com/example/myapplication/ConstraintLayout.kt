package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

class ConstraintLayout : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(), // Rellena toda la pantalla
                color = MaterialTheme.colorScheme.background // Fondo de la superficie
            ) {
                ButtonLayout() // Muestra el diseño de los botones
            }
        }
    }
}

@Composable
fun ButtonLayout() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize() // Rellena todo el espacio disponible
            .padding(16.dp) // Padding externo de la cuadrícula
    ) {
        // Define las referencias para los botones
        val (button1, button2, button3, button4, button5) = createRefs()

        Button(
            onClick = { /* Acción del botón */ },
            modifier = Modifier.constrainAs(button1) {
                top.linkTo(parent.top, margin = 16.dp) // Alinea al borde superior del contenedor
                start.linkTo(parent.start, margin = 16.dp) // Alinea al borde izquierdo del contenedor
                width = Dimension.wrapContent // Ajusta el ancho al contenido
            }
        ) {
            Text("Button 1", fontSize = 16.sp) // Texto del primer botón
        }

        Button(
            onClick = { /* Acción del botón */ },
            modifier = Modifier.constrainAs(button2) {
                top.linkTo(button1.bottom, margin = 16.dp) // Alinea al borde inferior del botón1
                start.linkTo(parent.start, margin = 16.dp) // Alinea al borde izquierdo del contenedor
                end.linkTo(parent.end, margin = 16.dp) // Alinea al borde derecho del contenedor
                width = Dimension.fillToConstraints // Ajusta el ancho para llenar el espacio disponible
            }
        ) {
            Text("Button 2", fontSize = 16.sp) // Texto del segundo botón
        }

        Button(
            onClick = { /* Acción del botón */ },
            modifier = Modifier.constrainAs(button3) {
                top.linkTo(button2.bottom, margin = 16.dp) // Alinea al borde inferior del botón2
                start.linkTo(parent.start, margin = 16.dp) // Alinea al borde izquierdo del contenedor
                width = Dimension.wrapContent // Ajusta el ancho al contenido
            }
        ) {
            Text("Button 3", fontSize = 16.sp) // Texto del tercer botón
        }

        Button(
            onClick = { /* Acción del botón */ },
            modifier = Modifier.constrainAs(button4) {
                top.linkTo(button3.bottom, margin = 16.dp) // Alinea al borde inferior del botón3
                end.linkTo(parent.end, margin = 16.dp) // Alinea al borde derecho del contenedor
                width = Dimension.wrapContent // Ajusta el ancho al contenido
            }
        ) {
            Text("Button 4", fontSize = 16.sp) // Texto del cuarto botón
        }

        Button(
            onClick = { /* Acción del botón */ },
            modifier = Modifier.constrainAs(button5) {
                bottom.linkTo(parent.bottom, margin = 16.dp) // Alinea al borde inferior del contenedor
                start.linkTo(parent.start, margin = 16.dp) // Alinea al borde izquierdo del contenedor
                end.linkTo(parent.end, margin = 16.dp) // Alinea al borde derecho del contenedor
                width = Dimension.fillToConstraints // Ajusta el ancho para llenar el espacio disponible
            }
        ) {
            Text("Button 5", fontSize = 16.sp) // Texto del quinto botón
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ConstraintLayoutPreview() {
    ButtonLayout() // Vista previa del diseño de los botones
}
