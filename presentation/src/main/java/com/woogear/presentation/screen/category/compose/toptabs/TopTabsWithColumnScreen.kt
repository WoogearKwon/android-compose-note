package com.woogear.presentation.screen.category.compose.toptabs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Tab
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.woogear.presentation.R
import com.woogear.presentation.theme.Black
import com.woogear.presentation.theme.White
import com.woogear.presentation.theme.backgroundColors
import kotlinx.coroutines.launch

private val myBoxes = listOf(
    ColorBox("one", Color(value = backgroundColors.random())),
    ColorBox("two", Color(value = backgroundColors.random())),
    ColorBox("three", Color(value = backgroundColors.random())),
    ColorBox("four", Color(value = backgroundColors.random())),
    ColorBox("five", Color(value = backgroundColors.random())),
    ColorBox("six", Color(value = backgroundColors.random())),
    ColorBox("seven", Color(value = backgroundColors.random())),
    ColorBox("eight", Color(value = backgroundColors.random())),
    ColorBox("nine", Color(value = backgroundColors.random())),
)

@Composable
fun TopTabsWithColumnScreen(
    boxes: List<ColorBox> = myBoxes,
    onClickExit: () -> Unit,
) {
    val coroutineScope = rememberCoroutineScope()
    val listState = rememberLazyListState()
    var scrollingByTabSelection by remember { mutableStateOf(false) }
    val scrollIndexState = remember { mutableStateOf(0) }

    LaunchedEffect(listState, listState.isScrollInProgress) {
        snapshotFlow { listState.firstVisibleItemIndex }
            .collect { index ->

                if (scrollingByTabSelection.not()) {
                    val bottomReached = listState.canScrollForward.not()
                    scrollIndexState.value = if (bottomReached) boxes.lastIndex else index
                }

                if (listState.isScrollInProgress.not()) {
                    scrollingByTabSelection = false
                }
            }
    }

    Scaffold(
        modifier = Modifier.fillMaxWidth(),
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = onClickExit) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = null)
                    }
                },
                title = {
                    Text(text = stringResource(R.string.bottomnavigation_title))
                }
            )
        },
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            TopNavigationTabs(
                selectedTabIndex = scrollIndexState.value,
                boxes = boxes,
                onTabIndexChanged = { index ->
                    scrollingByTabSelection = true
                    scrollIndexState.value = index

                    coroutineScope.launch {
                        listState.animateScrollToItem(index)
                    }
                }
            )
            BoxColumn(
                listState = listState,
                boxes = boxes,
            )
        }
    }
}

@Composable
private fun TopNavigationTabs(
    selectedTabIndex: Int,
    boxes: List<ColorBox>,
    onTabIndexChanged: (Int) -> Unit,
) {
    if (boxes.isEmpty()) return

    ScrollableTabRow(
        edgePadding = 0.dp,
        backgroundColor = White,
        contentColor = Black,
        selectedTabIndex = selectedTabIndex,
        divider = {}
    ) {
        boxes.forEachIndexed { index, box ->
            Tab(
                modifier = Modifier.width(60.dp),
                selected = index == selectedTabIndex,
                onClick = {
                    onTabIndexChanged(index)
                },
                text = {
                    Text(
                        text = box.name,
                        color = if (index == selectedTabIndex) Black else Color.Gray,
                    )
                }
            )
        }
    }
}

@Composable
private fun BoxColumn(
    listState: LazyListState,
    boxes: List<ColorBox>,
) {
    LazyColumn(state = listState) {
        itemsIndexed(items = boxes) { index, box ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .background(box.color),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = box.name,
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontSize = 44.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                    )
                )
            }
        }
    }
}

data class ColorBox(
    val name: String,
    val color: Color,
)