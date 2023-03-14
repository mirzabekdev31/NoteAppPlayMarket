package com.mirzabek.noteappplaymarket.data.sourse.apref

import android.content.Context
import android.content.SharedPreferences

class AppPref private constructor(){

    companion object {
        private lateinit var pref: SharedPreferences
        private lateinit var instance: AppPref

        fun init(context: Context) {
            pref = context.getSharedPreferences("MY_PREF", Context.MODE_PRIVATE)
            instance = AppPref()
        }
        fun getInstance(): AppPref = instance
    }

    var saveColor:String
        set(value) = pref.edit().putString("SAVECOLOR",value).apply()
        get() = pref.getString("SAVECOLOR","").toString()

}