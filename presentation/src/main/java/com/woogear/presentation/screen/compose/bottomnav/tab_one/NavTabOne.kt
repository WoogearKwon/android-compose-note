package com.woogear.presentation.screen.compose.bottomnav.tab_one

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.woogear.presentation.theme.RetroPink03Basic

@Composable
fun BottomNavTabOne(
    modifier: Modifier = Modifier.fillMaxSize()
) {
    Box(
        modifier = modifier.background(RetroPink03Basic),
    )
}