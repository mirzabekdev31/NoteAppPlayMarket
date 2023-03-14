package com.mirzabek.noteappplaymarket.app

import android.app.Application
import com.mirzabek.noteappplaymarket.data.sourse.apref.AppPref
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App :Application(){
    override fun onCreate() {
        super.onCreate()
        AppPref.init(this)
    }
}