package com.example.composecatalog

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composecatalog.examples.MyDialog
import com.example.composecatalog.examples.getOptions
import com.example.composecatalog.ui.theme.ComposeCatalogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {

            val myOptions = getOptions(titles = listOf("Josué", "Edgard", "Ardón"))
            var selected by remember {
                mutableStateOf("Josué")
            }
            var show by remember {
                mutableStateOf(false
            }

            ComposeCatalogTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(
                        modifier = Modifier.padding(innerPadding),
                        contentAlignment = Alignment.Center,
                    ) {
                        Column {
                            Button(
                                onClick = {
                                    show = true
                                }
                            ) {
                                Text(text = "Show")
                            }
                        }
                        MyDialog(
                            show = show,
                            onDismiss = {
                                show = false
                            },
                            onConfirm = {
                                Log.i("DialogButton", "Clicked!")
                            }
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeCatalogTheme {
        //MyText()
        //MyTextField()
        //MyTextFieldAdvance()
        //MyTextFieldOutline()
        //MyButtonExample()
        //MyImage()
        //MyImageAdvance()
        //MyIcon()
        //MyProgress()
        //MyProgressAdvance()
        //MySwitch()
        //MyCheckBox()
        //MyCheckBoxWithText()
        //MyTriStatusCheckBox()
        //MyRadioButton()
        //MyRadioButtonList("", {})
        //MyCard()
        //MyBadgeBox()
        //MyDivider()
        //MyDropDownMenu()
        //BasicSlider()
        //AdvanceSlider()
        //MyRangeSlider()
    }
}





















