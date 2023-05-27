package com.woogear.compose_note.ui.sceen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
    Column {
        Text(
            text = "Categories",
            color = Black,
            fontSize = 22.sp
        )
        Categories(viewModel.routes, onClickCategory)
    }
}

@Composable
fun Categories(routes: List<Route>, onClickCategory: (path: String) -> Unit) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier.padding(top = 20.dp, start = 20.dp, end = 20.dp)
    ) {
        items(routes) { route ->
            Button(onClick = { onClickCategory.invoke(route.routePath) }) {
                Text(text = route.name())
            }
        }
    }
}