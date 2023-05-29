package com.woogear.compose_note.ui.sceen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.woogear.compose_note.ui.navigation.Route
import com.woogear.compose_note.ui.theme.Black

@Composable
fun CategoriesScreen(
    modifier: Modifier = Modifier,
    viewModel: CategoriesViewModel,
    onClickCategory: (path: String) -> Unit,
) {
    Scaffold {
        Column(modifier = Modifier.padding(it)) {
            Text(
                text = "Categories",
                color = Black,
                fontSize = 22.sp
            )
            Categories(viewModel.routes, onClickCategory)
        }
    }
}

@Composable
fun Categories(routes: List<Route>, onClickCategory: (path: String) -> Unit) {
    val configuration = LocalConfiguration.current
    val itemWidth = (configuration.screenWidthDp.dp - 2.dp) / 2

    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(routes) { route ->
            Box(
                modifier = Modifier
                    .padding(4.dp)
                    .height(itemWidth)
                    .background(Color.LightGray)
                    .clickable { onClickCategory.invoke(route.routePath) },
            ) {
                Column(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start,
                ) {
                    Text(
                        text = route.name,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Start,
                        modifier = Modifier.padding(10.dp)
                    )
                    Text(
                        text = route.description,
                        fontSize = 12.sp,
                        textAlign = TextAlign.Start,
                        modifier = Modifier.padding(12.dp)
                    )
                }
            }
        }
    }
}