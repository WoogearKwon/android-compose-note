package com.woogear.presentation.screen.compose.bottomnav

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.woogear.presentation.screen.compose.bottomnav.tab_four.BottomNavTabFour
import com.woogear.presentation.screen.compose.bottomnav.tab_one.BottomNavTabOne
import com.woogear.presentation.screen.compose.bottomnav.tab_three.BottomNavTabThree
import com.woogear.presentation.screen.compose.bottomnav.tab_two.BottomNavTabTwo

@Composable
fun BottomNavScreen() {
    var selectedTab by remember { mutableStateOf(BottomNavTab.TabOne) }

    Scaffold(
        modifier = Modifier.fillMaxWidth(),
        bottomBar = {
            BottomTabRow(
                onTabSelected = {
                    selectedTab = it
                },
                selectedTab = selectedTab
            )
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .padding(innerPadding)
                .padding(bottom = 5.dp)
        ) {
            when (selectedTab) {
                BottomNavTab.TabFour -> BottomNavTabOne()
                BottomNavTab.TabOne -> BottomNavTabTwo()
                BottomNavTab.TabThree -> BottomNavTabThree()
                BottomNavTab.TabTwo -> BottomNavTabFour()
            }
        }
    }
}

@Composable
private fun BottomTabRow(
    onTabSelected: (BottomNavTab) -> Unit,
    selectedTab: BottomNavTab,
) {
    Surface(
        Modifier
            .fillMaxWidth()
    ) {
        BottomNavigation(
            backgroundColor = Color.White,
            modifier = Modifier.selectableGroup()
        ) {
            BottomNavTab.values().forEach { tab ->
                BottomNavigationItem(
                    icon = {
                        TabItem(tab = tab, selected = selectedTab == tab)
                    },
                    selected = selectedTab == tab,
                    onClick = { onTabSelected(tab) }
                )
            }
        }
    }
}

@Composable
private fun TabItem(
    tab: BottomNavTab,
    selected: Boolean,
) {
    Box(
        contentAlignment = Alignment.Center,
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Icon(
                modifier = Modifier.size(24.dp),
                imageVector = if (selected) tab.iconActive else tab.iconInactive,
                contentDescription = null
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = stringResource(id = tab.title),
                fontSize = 10.sp
            )
        }
    }
}