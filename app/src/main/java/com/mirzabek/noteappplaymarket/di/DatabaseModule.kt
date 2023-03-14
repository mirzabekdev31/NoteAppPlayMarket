package com.mirzabek.noteappplaymarket.di

import android.content.Context
import androidx.room.Room
import com.mirzabek.noteappplaymarket.data.sourse.room.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @[Provides Singleton]
    fun getDatabase(@ApplicationContext context:Context):AppDatabase=
        Room.databaseBuilder(context, AppDatabase::class.java, "Note").allowMainThreadQueries().build()
}