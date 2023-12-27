package com.woogear.presentation.screen.category.canvas.slider

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.woogear.presentation.R

@Composable
fun GradientSliderScreen(
    modifier: Modifier = Modifier,
    onClickExit: () -> Unit,
) {
    var sliderValue by remember { mutableFloatStateOf(0f) }
    var sliderColor by remember { mutableStateOf(Color.Black) }

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
                    Text(text = stringResource(R.string.gradient_Slider_title))
                }
            )
        },
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
        ) {
            GradientSlider(
                value = sliderValue,
                onValueChanged = { value ->
                    sliderValue = value
                },
                onColorChanged = { color ->
                    sliderColor = color
                }
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                "red: ${sliderColor.red * 256}",
                style = TextStyle(
                    fontSize = 18.sp,
                    color = Color.Red,
                )
            )
            Text(
                "green: ${sliderColor.green * 256}",
                style = TextStyle(
                    fontSize = 18.sp,
                    color = Color.Green,
                )
            )
            Text(
                "blue: ${sliderColor.blue * 256}",
                style = TextStyle(
                    fontSize = 18.sp,
                    color = Color.Blue,
                )
            )
        }
    }
}