package com.woogear.presentation.screen.category.compose.bottomnav.tab_one

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.woogear.presentation.theme.palettePink400

@Composable
fun BottomNavTabOne(
    modifier: Modifier = Modifier.fillMaxSize()
) {
    Box(
        modifier = modifier.background(palettePink400),
    )
}