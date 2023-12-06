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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Slider
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
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.woogear.presentation.R
import com.woogear.presentation.theme.paletteBlue070
import com.woogear.presentation.theme.paletteYellow100
import timber.log.Timber

@Composable
fun AutoSizingTextScreen(
    modifier: Modifier = Modifier,
    onClickExit: () -> Unit,
) {
    var firstCardHeight by remember { mutableStateOf(180f) }

    Scaffold(
        modifier = modifier.systemBarsPadding(),
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
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .padding(10.dp)
        ) {
            Slider(
                value = firstCardHeight,
                valueRange = 80f..220f,
                onValueChange = { newValue ->
                    firstCardHeight = newValue
                },
            )
            Text(text = "Height = ${firstCardHeight.toInt()}dp")
            Spacer(modifier = Modifier.height(10.dp))
            CardBox(
//                height = firstCardHeight.dp,
                background = paletteYellow100,
            ) {
                AutoSizedText(
                    modifier = Modifier.height(firstCardHeight.dp),
                    originalStyle = TextStyle(fontSize = 45.sp),
                    textColor = Color.White,
                    text = stringResource(id = R.string.auto_sizing_text_sample_short),
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            CardBox(
                modifier = Modifier.height(280.dp),
                background = paletteBlue070,
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    AutoSizedText(
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(1f),
                        originalStyle = TextStyle(fontSize = 18.sp),
                        textColor = Color.White,
                        text = "Lorem Ipsum",
                        scaleBy = TextScaleType.WIDTH
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    AutoSizedText(
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(1.5f),
                        originalStyle = TextStyle(fontSize = 18.sp),
                        textColor = Color.White,
                        text = stringResource(id = R.string.auto_sizing_text_sample_short),
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    AutoSizedText(
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(1.5f),
                        originalStyle = TextStyle(fontSize = 18.sp),
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
    originalStyle: TextStyle,
    textColor: Color,
    text: String,
    scaleBy: TextScaleType = TextScaleType.HEIGHT,
) {
    var size by remember { mutableStateOf(IntSize.Zero) }
    var textStyle by remember { mutableStateOf(originalStyle) }
    var readyToDraw by remember { mutableStateOf(false) }

    Text(
        modifier = modifier.drawWithContent {
                if (readyToDraw) drawContent()
            },
        text = text,
        maxLines = if (scaleBy == TextScaleType.HEIGHT) Int.MAX_VALUE else 1,
        color = textColor,
        style = textStyle,
        softWrap = scaleBy == TextScaleType.HEIGHT,
        onTextLayout = { textLayoutResult ->
            val newSize = textLayoutResult.size

            if (size != newSize) {
                if (size.height < newSize.height || size.width < newSize.width) {
                    // reset textStyle to Original style
                    textStyle = originalStyle
                }

                size = newSize
            }

            val didOverFlow =
                if (scaleBy == TextScaleType.HEIGHT) textLayoutResult.didOverflowHeight
                else textLayoutResult.didOverflowWidth

            if (didOverFlow) {
                textStyle = textStyle.copy(fontSize = textStyle.fontSize * 0.9)
                readyToDraw = false
            } else {
                readyToDraw = true
            }
        }
    )
}

@Composable
private fun CardBox(
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues = PaddingValues(vertical = 24.dp, horizontal = 16.dp),
    background: Color,
    onClick: (() -> Unit)? = null,
    content: @Composable BoxScope.() -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
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

