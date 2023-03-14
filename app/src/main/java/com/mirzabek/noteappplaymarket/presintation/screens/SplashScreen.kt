package com.mirzabek.noteappplaymarket.presintation.screens

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.mirzabek.noteappplaymarket.R
import kotlinx.coroutines.*

@SuppressLint("CustomSplashScreen")
class SplashScreen :Fragment(R.layout.splashscreen){

    private val scope=CoroutineScope(Dispatchers.Main+Job())

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        scope.launch {
            delay(4000)
            findNavController().navigate(SplashScreenDirections.actionSplashScreenToNotesScreen())
        }
    }
}