package com.woogear.presentation.screen.category.compose.paging

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.woogear.presentation.R

@Composable
fun PagingDemoScreen(
    modifier: Modifier = Modifier,
    viewModel: PagingDemoViewModel,
    onClickExit: () -> Unit,
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
                    Text(text = stringResource(R.string.paging_demo_title))
                }
            )
        },
    ) {
        val nameItems = viewModel.demoPagesFlow.collectAsLazyPagingItems()

        Box(modifier = Modifier.fillMaxSize()) {
            if (nameItems.loadState.refresh == LoadState.Loading) {
                CircularProgressIndicator(
                    modifier = Modifier.align(alignment = Alignment.Center)
                )
            }

            LazyColumn(
                modifier = Modifier.padding(it),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                items(count = nameItems.itemCount) { i ->
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(nameItems[i]?.color ?: Color.Blue)
                            .height(130.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = nameItems[i]?.name ?: "noname",
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 44.sp,
                                color = Color.White,
                                fontWeight = FontWeight.ExtraBold
                            )
                        )
                    }
                }
                if (nameItems.loadState.append == LoadState.Loading) {
                    item {
                        LinearProgressIndicator(
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }
        }
    }
}