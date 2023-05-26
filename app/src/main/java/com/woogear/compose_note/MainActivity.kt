package com.woogear.compose_note

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.woogear.compose_note.ui.sceen.CalculatorScreen
import com.woogear.compose_note.ui.theme.ComposeNoteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeNoteTheme {
                CalculatorScreen()
            }
        }
    }
}

