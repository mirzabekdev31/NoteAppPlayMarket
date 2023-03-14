package com.mirzabek.noteappplaymarket.extensions

import androidx.fragment.app.Fragment
import java.text.SimpleDateFormat
import java.util.*

fun Fragment.getCurrentData():String{
    return SimpleDateFormat("dd/MM/yyy", Locale.getDefault()).format(Date())
}