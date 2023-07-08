package com.woogear.compose_note.ui.screen.components.bottomnav

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.woogear.compose_note.R

enum class BottomNavTab(
    @StringRes val title: Int,
    val iconActive: ImageVector,
    val iconInactive: ImageVector
) {
    TabOne(
        R.string.bottom_nav_tab_one,
        Icons.Default.Favorite,
        Icons.Default.Favorite
    ),
    TabTwo(
        R.string.bottom_nav_tab_two,
        Icons.Default.AddCircle,
        Icons.Default.AddCircle
    ),
    TabThree(
        R.string.bottom_nav_tab_three,
        Icons.Default.Call,
        Icons.Default.Call
    ),
    TabFour(
        R.string.bottom_nav_tab_four,
        Icons.Default.Settings,
        Icons.Default.Settings
    ),
}
