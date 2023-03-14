package com.mirzabek.noteappplaymarket.data.sourse.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "notes")
class NotesEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int=0,
    val title:String,
    val description:String,
    val data:String,
    val backColor:Int
): Serializable