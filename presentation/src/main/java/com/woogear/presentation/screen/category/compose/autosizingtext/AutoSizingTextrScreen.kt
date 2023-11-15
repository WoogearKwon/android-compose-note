package com.woogear.presentation.screen.category.compose.autosizingtext

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.woogear.presentation.R
import com.woogear.presentation.theme.backgroundColors

@Composable
fun AutoSizingTextScreen(
    onClickExit: () -> Unit,
) {
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
                    Text(text = stringResource(R.string.auto_sizing_text_title))
                }
            )
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(10.dp)
        ) {
            CardBox(
                height = 180.dp,
                background = Color(backgroundColors.random()),
            ) {
                AutoSizedText(
                    modifier = Modifier.fillMaxHeight(),
                    style = TextStyle(fontSize = 22.sp),
                    textColor = Color.White,
                    text = stringResource(id = R.string.auto_sizing_text_sample_long),
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            CardBox(
                height = 280.dp,
                background = Color(backgroundColors.random()),
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    AutoSizedText(
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(1f),
                        style = TextStyle(fontSize = 18.sp),
                        textColor = Color.White,
                        text = "Lorem Ipsum",
                        scaleBy = TextScaleType.WIDTH
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    AutoSizedText(
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(1.5f),
                        style = TextStyle(fontSize = 18.sp),
                        textColor = Color.White,
                        text = stringResource(id = R.string.auto_sizing_text_sample_short),
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    AutoSizedText(
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(1.5f),
                        style = TextStyle(fontSize = 18.sp),
                        textColor = Color.White,
                        text = stringResource(id = R.string.auto_sizing_text_sample_long),
                    )
                }
            }
        }
    }
}

@Composable
private fun AutoSizedText(
    modifier: Modifier = Modifier,
    style: TextStyle,
    textColor: Color,
    text: String,
    scaleBy: TextScaleType = TextScaleType.HEIGHT,
) {
    var textStyle by remember { mutableStateOf(style) }
    var readyToDraw by remember { mutableStateOf(false) }

    Text(
        modifier = modifier.drawWithContent { if (readyToDraw) drawContent() },
        text = text,
        maxLines = if (scaleBy == TextScaleType.HEIGHT) Int.MAX_VALUE else 1,
        color = textColor,
        style = textStyle,
        softWrap = scaleBy == TextScaleType.HEIGHT,
        onTextLayout = { textLayoutResult ->
            val didOverFlow =
                if (scaleBy == TextScaleType.HEIGHT) textLayoutResult.didOverflowHeight
                else textLayoutResult.didOverflowWidth

            if (didOverFlow) {
                textStyle = textStyle.copy(fontSize = textStyle.fontSize * 0.9)
            } else {
                readyToDraw = true
            }
        }
    )
}

@Composable
private fun CardBox(
    modifier: Modifier = Modifier,
    height: Dp,
    paddingValues: PaddingValues = PaddingValues(vertical = 24.dp, horizontal = 16.dp),
    background: Color,
    onClick: (() -> Unit)? = null,
    content: @Composable BoxScope.() -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(height)
            .clip(shape = RoundedCornerShape(size = 24.dp))
            .background(background)
            .clickable(
                enabled = onClick != null,
                onClick = {
                    onClick?.invoke()
                }
            )
            .padding(paddingValues)
    ) {
        content()
    }
}

private enum class TextScaleType {
    HEIGHT,
    WIDTH
}

