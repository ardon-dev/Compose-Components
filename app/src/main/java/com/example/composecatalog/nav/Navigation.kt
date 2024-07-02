package com.example.composecatalog.nav

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.composecatalog.model.Routes

@Composable
fun Screen1(navController: NavController) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Cyan)) {
        Text(text = "Pantalla 1", modifier = Modifier.align(Alignment.Center).clickable {
            navController.navigate(Routes.Screen2.route)
        })
    }
}

@Composable
fun Screen2(navController: NavController) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Gray)) {
        Text(text = "Pantalla 2", modifier = Modifier.align(Alignment.Center).clickable {
            navController.navigate(Routes.Screen3.route)
        })
    }
}

@Composable
fun Screen3(navController: NavController) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Magenta)) {
        Text(text = "Pantalla 3", modifier = Modifier.align(Alignment.Center).clickable {
            navController.navigate(Routes.Screen4.createRoute(24))
        })
    }
}

@Composable
fun Screen4(navController: NavController, age: Int) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Magenta)) {
        Text(text = age.toString(), modifier = Modifier.align(Alignment.Center).clickable {
            navController.navigate(Routes.Screen5.createRoute("Josué"))
        })
    }
}

@Composable
fun Screen5(navController: NavController, name: String?) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Magenta)) {
        Text(text = "Me llamo $name", modifier = Modifier.align(Alignment.Center))
    }
}