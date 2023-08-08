package com.woogear.presentation.screen.category

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.woogear.presentation.model.ScreenCategory

@Composable
fun CategoriesScreen(
    modifier: Modifier = Modifier,
    viewModel: CategoriesViewModel,
    onClickCategory: (path: ScreenCategory) -> Unit,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Categories",
                        color = Color.White,
                        fontSize = 22.sp
                    )
                }
            )
        }
    ) {
        LazyColumn(
            modifier = Modifier.padding(it)
        ) {
            items(items = viewModel.screenCategories) { category ->
                Card(
                    elevation = 10.dp,
                    modifier = Modifier
                        .height(160.dp)
                        .fillMaxWidth()
                        .padding(10.dp)
                        .clickable { onClickCategory(category) },
                    backgroundColor = category.color,
                ) {
                    Row(
                        modifier = Modifier.padding(18.dp),
                    ) {
                        Text(
                            modifier = Modifier.weight(1f),
                            text = category.title,
                            textAlign = TextAlign.Start,
                            color = Color.White,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.width(20.dp))
                        Text(
                            modifier = Modifier.weight(2f),
                            text = category.description,
                            textAlign = TextAlign.Start,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}
