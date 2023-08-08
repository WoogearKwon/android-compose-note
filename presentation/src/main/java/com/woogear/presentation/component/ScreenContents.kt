package com.woogear.presentation.component

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
import com.woogear.presentation.model.Screen
import com.woogear.presentation.model.ScreenType

@Composable
fun Screens(
    modifier: Modifier = Modifier,
    screens: List<Screen>,
    onClickCategory: (screenType: ScreenType) -> Unit
) {
    val configuration = LocalConfiguration.current
    val itemWidth = (configuration.screenWidthDp.dp - 2.dp) / 2

    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(2)
    ) {
        items(screens) { screen ->
            Box(
                modifier = Modifier
                    .padding(4.dp)
                    .height(itemWidth)
                    .background(screen.color)
                    .clickable { onClickCategory(screen.type) },
            ) {
                Column(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start,
                ) {
                    Text(
                        modifier = Modifier.padding(10.dp),
                        text = screen.title,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Start,
                        color = Color.White,
                    )
                    Text(
                        modifier = Modifier.padding(12.dp),
                        text = screen.description,
                        fontSize = 12.sp,
                        textAlign = TextAlign.Start,
                        color = Color.White,
                    )
                }
            }
        }
    }
}
