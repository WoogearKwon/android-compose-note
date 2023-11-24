package com.woogear.presentation.screen.category.compose.stickyheader.model

import androidx.compose.ui.graphics.Color
import com.woogear.presentation.theme.paletteGreen100
import com.woogear.presentation.theme.paletteIndigo400
import com.woogear.presentation.theme.paletteLightblue100
import com.woogear.presentation.theme.paletteOrange100
import com.woogear.presentation.theme.palettePurple100
import com.woogear.presentation.theme.paletteRed100
import com.woogear.presentation.theme.paletteYellow100

data class StickyHeaderChild(
    val name: String,
    val colorName: String,
    val color: Color
)

private val reds = listOf(
    StickyHeaderChild(name = "red1", colorName = "red", color = paletteRed100),
    StickyHeaderChild(name = "red2", colorName = "red", color = paletteRed100),
    StickyHeaderChild(name = "red3", colorName = "red", color = paletteRed100),
    StickyHeaderChild(name = "red4", colorName = "red", color = paletteRed100),
    StickyHeaderChild(name = "red5", colorName = "red", color = paletteRed100),
    StickyHeaderChild(name = "red6", colorName = "red", color = paletteRed100),
    StickyHeaderChild(name = "red7", colorName = "red", color = paletteRed100),
)

private val oranges = listOf(
    StickyHeaderChild(name = "orange1", colorName = "orange", color = paletteOrange100),
    StickyHeaderChild(name = "orange2", colorName = "orange", color = paletteOrange100),
    StickyHeaderChild(name = "orange3", colorName = "orange", color = paletteOrange100),
    StickyHeaderChild(name = "orange4", colorName = "orange", color = paletteOrange100),
    StickyHeaderChild(name = "orange5", colorName = "orange", color = paletteOrange100),
    StickyHeaderChild(name = "orange6", colorName = "orange", color = paletteOrange100),
    StickyHeaderChild(name = "orange7", colorName = "orange", color = paletteOrange100),
)

private val yellows = listOf(
    StickyHeaderChild(name = "yellow1", colorName = "yellow", color = paletteYellow100),
    StickyHeaderChild(name = "yellow2", colorName = "yellow", color = paletteYellow100),
    StickyHeaderChild(name = "yellow3", colorName = "yellow", color = paletteYellow100),
    StickyHeaderChild(name = "yellow4", colorName = "yellow", color = paletteYellow100),
    StickyHeaderChild(name = "yellow5", colorName = "yellow", color = paletteYellow100),
    StickyHeaderChild(name = "yellow6", colorName = "yellow", color = paletteYellow100),
    StickyHeaderChild(name = "yellow7", colorName = "yellow", color = paletteYellow100),
)

private val greens = listOf(
    StickyHeaderChild(name = "green1", colorName = "green", color = paletteGreen100),
    StickyHeaderChild(name = "green2", colorName = "green", color = paletteGreen100),
    StickyHeaderChild(name = "green3", colorName = "green", color = paletteGreen100),
    StickyHeaderChild(name = "green4", colorName = "green", color = paletteGreen100),
    StickyHeaderChild(name = "green5", colorName = "green", color = paletteGreen100),
    StickyHeaderChild(name = "green6", colorName = "green", color = paletteGreen100),
    StickyHeaderChild(name = "green7", colorName = "green", color = paletteGreen100),
)

private val blues = listOf(
    StickyHeaderChild(name = "blue1", colorName = "blue", color = paletteLightblue100),
    StickyHeaderChild(name = "blue2", colorName = "blue", color = paletteLightblue100),
    StickyHeaderChild(name = "blue3", colorName = "blue", color = paletteLightblue100),
    StickyHeaderChild(name = "blue4", colorName = "blue", color = paletteLightblue100),
    StickyHeaderChild(name = "blue5", colorName = "blue", color = paletteLightblue100),
    StickyHeaderChild(name = "blue6", colorName = "blue", color = paletteLightblue100),
    StickyHeaderChild(name = "blue7", colorName = "blue", color = paletteLightblue100),
)

private val navies = listOf(
    StickyHeaderChild(name = "navy1", colorName = "navy", color = paletteIndigo400),
    StickyHeaderChild(name = "navy2", colorName = "navy", color = paletteIndigo400),
    StickyHeaderChild(name = "navy3", colorName = "navy", color = paletteIndigo400),
    StickyHeaderChild(name = "navy4", colorName = "navy", color = paletteIndigo400),
    StickyHeaderChild(name = "navy5", colorName = "navy", color = paletteIndigo400),
    StickyHeaderChild(name = "navy6", colorName = "navy", color = paletteIndigo400),
    StickyHeaderChild(name = "navy7", colorName = "navy", color = paletteIndigo400),
)

private val purples = listOf(
    StickyHeaderChild(name = "purple1", colorName = "purple", color = palettePurple100),
    StickyHeaderChild(name = "purple2", colorName = "purple", color = palettePurple100),
    StickyHeaderChild(name = "purple3", colorName = "purple", color = palettePurple100),
    StickyHeaderChild(name = "purple4", colorName = "purple", color = palettePurple100),
    StickyHeaderChild(name = "purple5", colorName = "purple", color = palettePurple100),
    StickyHeaderChild(name = "purple6", colorName = "purple", color = palettePurple100),
    StickyHeaderChild(name = "purple7", colorName = "purple", color = palettePurple100),
)

val mockColors: List<StickyHeaderChild> =
    reds + oranges + yellows + greens + blues + navies + purples