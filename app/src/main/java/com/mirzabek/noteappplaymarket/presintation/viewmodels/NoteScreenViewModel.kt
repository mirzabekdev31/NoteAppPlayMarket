package com.mirzabek.noteappplaymarket.presintation.viewmodels

import com.mirzabek.noteappplaymarket.data.sourse.room.entity.NotesEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharedFlow

interface NoteScreenViewModel {
    val openNoteAddScreen:SharedFlow<Unit>

    fun getAllNotes():Flow<List<NotesEntity>>
    fun clickAddButton()
    fun deleteNotes(notesEntity: NotesEntity)
    fun updateNotes(notesEntity: NotesEntity)
    fun getQueryNotes(query: String):Flow<List<NotesEntity>>

}