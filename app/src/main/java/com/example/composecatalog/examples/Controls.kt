package com.example.composecatalog.examples

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp

@Composable
fun MyRadioButtonList(name: String, onItemSelected: (String) -> Unit) {

    Column(
        Modifier.fillMaxWidth()
    ) {
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = name == "Ejemplo 1",
                onClick = {
                    onItemSelected("Ejemplo 1")
                },
            )
            Text(text = "Ejemplo 1")
        }
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = name == "Ejemplo 2",
                onClick = {
                    onItemSelected("Ejemplo 2")
                },
            )
            Text(text = "Ejemplo 2")
        }
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = name == "Ejemplo 3",
                onClick = {
                    onItemSelected("Ejemplo 3")
                },
            )
            Text(text = "Ejemplo 3")
        }
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = name == "Ejemplo 4",
                onClick = {
                    onItemSelected("Ejemplo 4")
                },
            )
            Text(text = "Ejemplo 4")
        }
    }

}

@Composable
fun MyRadioButton() {

    var state by rememberSaveable {
        mutableStateOf(false)
    }

    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        RadioButton(
            selected = state, onClick = {
                state = !state
            }, colors = RadioButtonDefaults.colors(
                selectedColor = Color.Red,
                unselectedColor = Color.Yellow,
                disabledSelectedColor = Color.Black,
                disabledUnselectedColor = Color.Black
            )
        )
        Text(text = "Ejemplo 1")
    }

}

@Composable
fun MyTriStatusCheckBox() {

    var status by rememberSaveable {
        mutableStateOf(ToggleableState.Off)
    }

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        TriStateCheckbox(state = status, onClick = {
            status = when (status) {
                ToggleableState.On -> ToggleableState.Off
                ToggleableState.Off -> ToggleableState.Indeterminate
                ToggleableState.Indeterminate -> ToggleableState.On
            }
        })
        Text(text = "Hello")
    }

}

@Composable
fun MyCheckBoxWithTextCompleted(checkInfo: CheckInfo) {

    Row(
        Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(checked = checkInfo.selected,
            onCheckedChange = { checkInfo.onCheckedChange(!checkInfo.selected) })
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = checkInfo.title)
    }

}

@Composable
fun getOptions(titles: List<String>): List<CheckInfo> {
    return titles.map {
        var status by rememberSaveable {
            mutableStateOf(false)
        }
        CheckInfo(title = it, selected = status, onCheckedChange = { newStatus ->
            status = newStatus
        })
    }
}

@Composable
fun MyCheckBoxWithText() {

    var state by rememberSaveable {
        mutableStateOf(true)
    }

    Row(
        Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(checked = state, onCheckedChange = { state = !state })
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "Ejemplo 1")
    }


}

@Composable
fun MyCheckBox() {

    var state by rememberSaveable {
        mutableStateOf(true)
    }

    Checkbox(
        checked = state, onCheckedChange = { state = !state }, colors = CheckboxDefaults.colors(
            checkedColor = Color.Red, uncheckedColor = Color.Yellow, checkmarkColor = Color.Green
        )
    )

}

@Composable
fun MySwitch() {

    var state by rememberSaveable {
        mutableStateOf(true)
    }

    Switch(
        checked = state, onCheckedChange = {
            state = !state
        }, enabled = true, colors = SwitchDefaults.colors(
            uncheckedThumbColor = Color.Red,
            checkedThumbColor = Color.Green,
            checkedTrackColor = Color.Magenta,
            uncheckedTrackColor = Color.Yellow
        )
    )

}