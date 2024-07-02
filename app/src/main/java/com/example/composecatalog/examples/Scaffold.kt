package com.example.composecatalog.examples

import android.content.res.Resources.Theme
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun ScaffoldExample() {
    var snackbarHostState = remember {
        SnackbarHostState()
    }
    val coroutineScope = rememberCoroutineScope()
    var drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    ModalNavigationDrawer(
        drawerContent = { MyNavDrawer(
            onCloseDrawer = {
                coroutineScope.launch {
                    drawerState.close()
                }
            }
        )},
        drawerState = drawerState 
    ) {
        Scaffold(
            topBar = {
                MyTopAppBar(
                    onClickIcon = {
                        coroutineScope.launch {
                            snackbarHostState.showSnackbar(it)
                        }
                    },
                    onNavIconClick = {
                        coroutineScope.launch {
                            if (drawerState.isClosed) drawerState.open()
                        }
                    }
                )
            },
            bottomBar = {
                MyBottomNavigation()
            },
            snackbarHost = {
                SnackbarHost(hostState = snackbarHostState)
            },
            floatingActionButton = {
                MyFab()
            },

            ) { _ ->

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(onClickIcon: (String) -> Unit, onNavIconClick: () -> Unit) {
    TopAppBar(
        title = {
            Text(text = "Mi primer Top App Bar")
        },
        navigationIcon = {
            IconButton(onClick = {
                onNavIconClick()
            }) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu")
            }
        },
        actions = {
            IconButton(onClick = { onClickIcon("Search") }) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Search"
                )
            }
            IconButton(onClick = { onClickIcon("Close") }) {
                Icon(
                    imageVector = Icons.Filled.Close,
                    contentDescription = "Close"
                )
            }
        }
    )
}

@Composable
fun MyBottomNavigation() {
    var index by remember {
        mutableStateOf(0)
    }

    NavigationBar {
        NavigationBarItem(
            selected = index == 0,
            onClick = {
                index = 0
            },
            icon = {
                Icon(
                    imageVector = Icons.Filled.Favorite,
                    contentDescription = "Favs"
                )
            },
            label = { Text(text = "Favs") }
        )
        NavigationBarItem(
            selected = index == 1,
            onClick = {
                index = 1
            },
            icon = {
                Icon(
                    imageVector = Icons.Filled.Home,
                    contentDescription = "Home"
                )
            },
            label = { Text(text = "Home") }
        )
        NavigationBarItem(
            selected = index == 2,
            onClick = {
                index = 2
            },
            icon = {
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = "Profile"
                )
            },
            label = { Text(text = "Profile") }
        )
    }
}

@Composable
fun MyFab() {
    FloatingActionButton(
        onClick = {

        }
    ) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = "Add")
    }
}

@Composable
fun MyNavDrawer(
    onCloseDrawer: () -> Unit
) {
    Column(
        modifier = Modifier.padding(8.dp).background(Color.Black)
    ) {
        TextButton(
            onClick = { onCloseDrawer() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text(text = "Primera opción")
        }
        TextButton(
            onClick = { onCloseDrawer() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text(text = "Segunda opción")
        }
        TextButton(
            onClick = { onCloseDrawer() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text(text = "Tercera opción")
        }
    }
}