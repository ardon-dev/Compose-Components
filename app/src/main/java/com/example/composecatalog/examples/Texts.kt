package com.example.composecatalog.examples

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp

@Composable
fun MyText() {
    Column(Modifier.fillMaxSize()) {
        Text(text = "Example")
        Text(text = "Example", color = Color.Blue)
        Text(text = "Example", fontWeight = FontWeight.ExtraBold)
        Text(text = "Example", fontWeight = FontWeight.Light)
        Text(text = "Example", fontFamily = FontFamily.Cursive)
        Text(text = "Example", textDecoration = TextDecoration.LineThrough)
        Text(text = "Example", textDecoration = TextDecoration.Underline)
        Text(
            text = "Example", textDecoration = TextDecoration.combine(
                listOf(
                    TextDecoration.Underline, TextDecoration.LineThrough
                )
            )
        )
        Text(text = "Example", fontSize = 30.sp)
    }
}