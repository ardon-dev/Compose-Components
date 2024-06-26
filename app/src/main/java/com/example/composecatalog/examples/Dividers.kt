package com.example.composecatalog.examples

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun MyDivider() {
    Divider(
        modifier = Modifier.fillMaxWidth(), color = Color.Red
    )
}