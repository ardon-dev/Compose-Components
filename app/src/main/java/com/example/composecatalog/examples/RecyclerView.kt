package com.example.composecatalog.examples

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composecatalog.R
import com.example.composecatalog.model.SuperHero
import kotlinx.coroutines.launch

@Composable
fun SimpleRecyclerView() {

    val myList = listOf("Josué", "Pepe", "Manolo", "Jaime")

    LazyColumn {
        items(myList) {
            Text(text = "Hola, me llamo $it")
        }
    }

}

@Composable
fun SuperHeroView() {
    val context = LocalContext.current

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(getSuperHeroes()) { superHero ->
            SuperHeroItem(
                superHero = superHero,
                onItemClick = {
                    Toast.makeText(context, it.superHeroName, Toast.LENGTH_SHORT).show()
                }
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SuperHeroStickyView() {
    val context = LocalContext.current
    val superhero = getSuperHeroes().groupBy { it.publisher }

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        superhero.forEach { (publisher, mySuperHero) ->

            stickyHeader {
                Text(
                    text = publisher,
                    modifier = Modifier.fillMaxWidth().background(Color.Red),
                    fontSize = 16.sp,
                    color = Color.White
                )
            }

            items(mySuperHero) { superHero ->
                SuperHeroItem(
                    superHero = superHero,
                    onItemClick = {
                        Toast.makeText(context, it.superHeroName, Toast.LENGTH_SHORT).show()
                    }
                )
            }
        }
    }
}

@Composable
fun SuperHeroWithSpecialControl() {
    val context = LocalContext.current
    val rvState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Column {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            state = rvState,
            modifier = Modifier.weight(1f)
        ) {
            items(getSuperHeroes()) { superHero ->
                SuperHeroItem(
                    superHero = superHero,
                    onItemClick = {
                        Toast.makeText(context, it.superHeroName, Toast.LENGTH_SHORT).show()
                    }
                )
            }
        }

        val showButton by remember {
            derivedStateOf {
                rvState.firstVisibleItemIndex > 0
            }
        }

        if (showButton) {
            Button(onClick = {
                coroutineScope.launch { rvState.animateScrollToItem(0) }
            }, modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp)) {
                Text(text = "YEah")
            }
        }
    }
}

@Composable
fun SuperHeroGridView() {
    val context = LocalContext.current
    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(getSuperHeroes()) { superHero ->
            SuperHeroItem(
                superHero = superHero,
                onItemClick = {
                    Toast.makeText(context, it.superHeroName, Toast.LENGTH_SHORT).show()
                }
            )
        }
    }
}

@Composable
fun SuperHeroItem(
    superHero: SuperHero,
    onItemClick: (SuperHero) -> Unit
) {
    Card(
        border = BorderStroke(
            width = 2.dp,
            color = Color.Red
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, bottom = 8.dp, start = 16.dp, end = 16.dp)
            .clickable {
                onItemClick(superHero)
            }
    ) {
        Column {
            Image(
                painter = painterResource(superHero.photo),
                contentDescription = "Avatar",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
            )
            Column(
                Modifier
                    .padding(8.dp)
                    .fillMaxWidth()) {
                Text(text = superHero.superHeroName, modifier = Modifier.align(Alignment.CenterHorizontally))
                Text(text = superHero.realName, modifier = Modifier.align(Alignment.CenterHorizontally), fontSize = 12.sp)
                Text(text = superHero.publisher, modifier = Modifier.align(Alignment.End), fontSize = 10.sp)
            }
        }
    }
}

@Preview
@Composable
fun SuperHeroItemPreview() {
    SuperHeroItem(superHero = getSuperHeroes()[0]) {}
}


fun getSuperHeroes(): List<SuperHero> {
    return listOf(
        SuperHero("Spider-Man", "Peter Parker", "Marvel", R.drawable.spiderman),
        SuperHero("Wolverine", "Logan", "Marvel", R.drawable.logan),
        SuperHero("Batman", "Bruce Wayne", "DC", R.drawable.batman),
        SuperHero("Thor", "Thor Odinson", "Marvel", R.drawable.thor),
        SuperHero("Flash", "Barry Allen", "DC", R.drawable.flash),
        SuperHero("Green Lantern", "Allan Scott", "DC", R.drawable.green_lantern),
        SuperHero("Wonder Woman", "Diana", "DC", R.drawable.wonder_woman)
    )
}