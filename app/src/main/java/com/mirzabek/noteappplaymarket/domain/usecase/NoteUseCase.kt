package com.mirzabek.noteappplaymarket.domain.usecase

import com.mirzabek.noteappplaymarket.data.sourse.room.entity.NotesEntity
import kotlinx.coroutines.flow.Flow


interface NoteUseCase {

    fun getAllNotes(): Flow<List<NotesEntity>>
    fun deleteNotes(notesEntity: NotesEntity)
    fun updateNotes(notesEntity: NotesEntity)
    fun getNotesId(id:Int):Flow<NotesEntity>
    fun getQueryNotes(query: String): Flow<List<NotesEntity>>
}