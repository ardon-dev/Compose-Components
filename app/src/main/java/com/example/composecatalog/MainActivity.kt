package com.example.composecatalog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.composecatalog.examples.ColorAnimationSimple
import com.example.composecatalog.examples.CrossFadeExampleAnimation
import com.example.composecatalog.examples.SimpleRecyclerView
import com.example.composecatalog.examples.SizeAnimation
import com.example.composecatalog.examples.VisibilityAnimation
import com.example.composecatalog.examples.getOptions
import com.example.composecatalog.model.Routes
import com.example.composecatalog.nav.Screen1
import com.example.composecatalog.nav.Screen2
import com.example.composecatalog.nav.Screen3
import com.example.composecatalog.nav.Screen4
import com.example.composecatalog.nav.Screen5
import com.example.composecatalog.ui.theme.ComposeCatalogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            ComposeCatalogTheme {
                CrossFadeExampleAnimation()
            }
            /*
            val myOptions = getOptions(titles = listOf("Josué", "Edgard", "Ardón"))
            var selected by remember {
                mutableStateOf("Josué")
            }
            var show by remember {
                mutableStateOf(false)
            }
            ComposeCatalogTheme {
                //ScaffoldExample()
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Routes.Screen1.route) {
                    composable(Routes.Screen1.route) {
                        Screen1(navController)
                    }
                    composable(Routes.Screen2.route) {
                        Screen2(navController)
                    }
                    composable(Routes.Screen3.route) {
                        Screen3(navController)
                    }
                    composable(
                        Routes.Screen4.route,
                        arguments = listOf(navArgument("age") {
                            type = NavType.IntType
                        }
                        )) { backStackEntry ->
                        val a = backStackEntry.arguments?.getInt("age")
                        Screen4(navController, a ?: 0)
                    }
                    composable(
                        Routes.Screen5.route,
                        arguments = listOf(
                            navArgument("name") { defaultValue = "pepe" }
                        )
                    ) { navBackStackEntry ->
                        Screen5(
                            navController = navController,
                            name = navBackStackEntry.arguments?.getString("name")
                        )
                    }
                }
            }
            *
             */
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
        /*MyCustomDialog(
            show = true,
            title = "Setup backup account",
            onAccountSelect = {

            },
            onDismiss = {

            }
        )*/
        //MyConfirmationDialog(show = true) {}
        SimpleRecyclerView()
    }
}





















