package com.woogear.presentation.screen.category.compose.stickyheader

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.woogear.presentation.R
import com.woogear.presentation.screen.category.compose.stickyheader.model.StickyHeaderChild
import com.woogear.presentation.screen.category.compose.stickyheader.model.mockColors

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun StickyHeaderScreen(
    modifier: Modifier = Modifier,
    items: List<StickyHeaderChild> = mockColors,
    onClickExit: () -> Unit,
) {
    Scaffold(
        modifier = modifier.fillMaxWidth(),
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = onClickExit) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = null)
                    }
                },
                title = {
                    Text(text = stringResource(R.string.sticky_header_title))
                }
            )
        },
    ) {
        LazyColumn(
            Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            items.forEachIndexed { index, item ->
                val lastItem = if (index == 0) null else items[index - 1]
                val colorChanged = item.color != lastItem?.color

                if (colorChanged) {
                    stickyHeader {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Text(
                                modifier = Modifier.fillMaxSize(),
                                text = item.colorName,
                                style = TextStyle(
                                    fontSize = 36.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    fontStyle = FontStyle.Italic
                                )
                            )
                        }
                    }
                }
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(120.dp)
                            .padding(bottom = 2.dp)
                            .background(color = item.color),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = item.name,
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                color = Color.White,
                                fontSize = 44.sp,
                                fontWeight = FontWeight.ExtraBold,
                                fontStyle = FontStyle.Italic
                            )
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun StickyHeaderScreen_Preview() {
    StickyHeaderScreen {}
}
