package com.woogear.compose_calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.woogear.compose_calculator.ui.sceen.CalculatorScreen
import com.woogear.compose_calculator.ui.theme.ComposecalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposecalculatorTheme {
                CalculatorScreen()
            }
        }
    }
}

