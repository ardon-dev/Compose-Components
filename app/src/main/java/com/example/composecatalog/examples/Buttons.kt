package com.example.composecatalog.examples

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyButtonExample() {

    var enabled by rememberSaveable {
        mutableStateOf(true)
    }

    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {

        //Boton normal
        Button(
            onClick = {
                enabled = false
            }, colors = ButtonDefaults.buttonColors(
                containerColor = Color.Magenta, contentColor = Color.Blue
            ), border = BorderStroke(5.dp, color = Color.Green), enabled = enabled
        ) {
            Text(text = "Hola")
        }

        OutlinedButton(
            onClick = {
                enabled = false
            }, modifier = Modifier.padding(top = 8.dp), colors = ButtonDefaults.buttonColors(
                containerColor = Color.Magenta,
                contentColor = Color.Blue,
                disabledContentColor = Color.Yellow,
                disabledContainerColor = Color.Yellow
            ), enabled = enabled
        ) {
            Text(text = "Botón 2")
        }

        TextButton(onClick = { }) {
            Text(text = "Hola")
        }

    }
}