package com.mirzabek.noteappplaymarket.data.sourse.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mirzabek.noteappplaymarket.data.sourse.room.dao.NoteDao
import com.mirzabek.noteappplaymarket.data.sourse.room.entity.NotesEntity

@Database(entities = [NotesEntity::class], version = 1)
abstract class AppDatabase :RoomDatabase(){
    abstract fun eventDao():NoteDao
}