package com.woogear.compose_note.ui.sceen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.woogear.compose_note.ui.theme.Black
import com.woogear.compose_note.ui.theme.Orange
import com.woogear.compose_note.ui.theme.White

@Composable
fun CalculatorScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Black
    ) {
        Column(
            modifier = Modifier
                .padding(
                    start = 10.dp, end = 10.dp, bottom = 10.dp
                ),
            verticalArrangement = Arrangement.Bottom
        ) {
            DigitDisplayView()
            ButtonsGrid()
        }
    }
}

@Composable
fun DigitDisplayView() {
    Text(
        text = "0",
        style = MaterialTheme.typography.subtitle2.copy(
            fontSize = 82.sp,
            color = White
        ),
        textAlign = TextAlign.End,
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 15.dp)
    )
}

@Composable
fun ButtonsGrid() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(4),
    ) {
        items(20) {
            CircularButton()
        }
    }
}


@Composable
fun CircularButton() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.padding(bottom = 10.dp)
    ) {
        Card(
            modifier = Modifier
                .width(80.dp)
                .height(80.dp)
                .clip(CircleShape)
                .fillMaxSize(),
            backgroundColor = Orange
        ) {
            Text(
                "3",
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = 48.sp,
                    color = White
                ),
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}