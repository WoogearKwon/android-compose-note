package com.woogear.compose_note

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ComposeNoteApp : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}