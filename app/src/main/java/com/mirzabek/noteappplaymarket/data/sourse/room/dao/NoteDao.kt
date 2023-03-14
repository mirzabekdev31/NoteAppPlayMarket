package com.mirzabek.noteappplaymarket.data.sourse.room.dao

import androidx.room.*
import com.mirzabek.noteappplaymarket.data.sourse.room.entity.NotesEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(notesEntity: NotesEntity)

    @Update
    fun updateNotes(notesEntity: NotesEntity)

    @Delete
    fun deleteNotes(notesEntity: NotesEntity)

    @Query("SELECT*FROM notes")
    fun getAllNotes(): Flow<List<NotesEntity>>

    @Query("select*from notes where notes.id==:id")
    fun getNotesId(id:Int):Flow<NotesEntity>

    @Query("select * from notes where notes.title like '%'||:query||'%'")
    fun getSearchNotes(query:String):Flow<List<NotesEntity>>
}