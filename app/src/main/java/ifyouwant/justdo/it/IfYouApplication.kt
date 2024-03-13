package ifyouwant.justdo.it

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class IfYouApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}