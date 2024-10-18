package dam.nathan.poolkmpngm

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import poolkmpngm.composeapp.generated.resources.Res
import poolkmpngm.composeapp.generated.resources.compose_multiplatform


@Composable
@Preview
fun App() {
    MaterialTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Formulario(
                Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
            )
        }
    }
}   

@Composable
fun Formulario(modifier: Modifier = Modifier) {
    var metrosCubicos by remember { mutableStateOf("") }
    var ph by remember { mutableStateOf("") }
    var gramos by remember { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxSize().padding(64.dp)) {
        Row(Modifier.fillMaxWidth(1.0f)) {
            TextField(
                modifier = Modifier.fillMaxWidth().testTag("m3"),
                value = metrosCubicos,
                label = { Text("Metros cúbicos") },
                onValueChange = {
                    metrosCubicos = it
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
        }
        Row(Modifier.fillMaxWidth(1.0f)) {
            TextField(
                modifier = Modifier.fillMaxWidth().testTag("ph"),
                value = ph,
                label = { Text("Lectura de PH")},
                onValueChange =  {
                    ph = it
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
            )
        }
        Row(Modifier.fillMaxWidth(1.0f)) {
            TextField(
                modifier = Modifier.fillMaxWidth().testTag("g"),
                value = gramos,
                label = { Text("Gramos m³") },
                onValueChange = {
                    gramos = it
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
            )
        }
        Row() {
            Text(
                if(metrosCubicos.isNotEmpty() && ph.isNotEmpty() && gramos.isNotEmpty()) {
                    ((7.4 - ph.toDouble()) * 10 * metrosCubicos.toInt() * gramos.toInt()).toString()
                } else {
                    "Debes rellenar todos los datos"
                },
                modifier = modifier.background(Color.Red).testTag("resultado")
            )
        }
    }
}

/**
 *         var showContent by remember { mutableStateOf(false) }
 *         Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
 *             Button(onClick = { showContent = !showContent }) {
 *                 Text("Click me!")
 *             }
 *             AnimatedVisibility(showContent) {
 *                 val greeting = remember { Greeting().greet() }
 *                 Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
 *                     Image(painterResource(Res.drawable.compose_multiplatform), null)
 *                     Text("Compose: $greeting")
 *                 }
 *             }
 *         }
 */

