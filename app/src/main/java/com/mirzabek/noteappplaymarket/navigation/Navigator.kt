package com.mirzabek.noteappplaymarket.navigation
import androidx.navigation.NavDirections

interface Navigator {

    suspend fun navigateTo(direction: NavDirections)

    suspend fun navigationUp()

}