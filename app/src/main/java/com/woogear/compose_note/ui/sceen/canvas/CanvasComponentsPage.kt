package com.woogear.compose_note.ui.sceen.canvas

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
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.woogear.compose_note.ui.theme.RetroBlue03Basic
import com.woogear.compose_note.ui.theme.White

@Composable
fun CanvasComponentsPage(
    viewModel: CanvasComponentsViewModel,
    onClickExit: () -> Unit,
    onClickComponent: (path: String) -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = onClickExit) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = null)
                    }
                },
                title = {
                    Text(text = "Custom UI Components on Canvas")
                }
            )
        },
    ) {
        LazyColumn(
            modifier = Modifier.padding(it)
        ) {
            items(viewModel.routes) { route ->
                Card(
                    elevation = 10.dp,
                    modifier = Modifier
                        .height(160.dp)
                        .fillMaxWidth()
                        .padding(10.dp)
                        .clickable { onClickComponent.invoke(route.routePath) },
                    backgroundColor = RetroBlue03Basic
                ) {
                    Row(
                        modifier = Modifier.padding(18.dp),
                    ) {
                        Text(
                            modifier = Modifier.weight(1f),
                            text = route.name,
                            textAlign = TextAlign.Start,
                            color = White,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.width(20.dp))
                        Text(
                            modifier = Modifier.weight(2f),
                            text = route.description,
                            textAlign = TextAlign.Start,
                            color = White
                        )
                    }
                }
            }
        }
    }
}