package com.example.composecatalog.examples

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun BasicSlider() {

    Column {
        var position by remember {
            mutableFloatStateOf(0f)
        }

        Slider(
            value = position,
            onValueChange = {
                position = it
            }
        )

        Text(text = position.toString())

    }

}

@Composable
fun AdvanceSlider() {
    Column {
        var position by remember {
            mutableFloatStateOf(0f)
        }

        var completeValue by remember {
            mutableStateOf("")
        }

        Slider(
            value = position,
            valueRange = 0f..10f,
            steps = 9,
            onValueChange = {
                position = it
            },
            onValueChangeFinished = {
                completeValue = position.toInt().toString()
            }
        )

        Text(text = completeValue)

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyRangeSlider() {

    Column {
        var currentRange by remember {
            mutableStateOf(0f..10f)
        }

        RangeSlider(
            value = currentRange,
            valueRange = 0f..10f,
            steps = 9,
            onValueChange = {
                currentRange = it
            }
        )

        Text(text = "Valor inferior: ${currentRange.start}")
        Text(text = "Valor superior: ${currentRange.endInclusive}")
    }

}