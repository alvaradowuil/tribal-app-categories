package com.alvarado.tribaljob

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class TribalJobApplication: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}