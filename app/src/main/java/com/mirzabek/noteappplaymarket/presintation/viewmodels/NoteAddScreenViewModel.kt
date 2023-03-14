package com.mirzabek.noteappplaymarket.presintation.viewmodels

import com.mirzabek.noteappplaymarket.data.sourse.room.entity.NotesEntity
import kotlinx.coroutines.flow.MutableSharedFlow

interface NoteAddScreenViewModel {
    val addNotes: MutableSharedFlow<Unit>

    fun insertNote(notesEntity: NotesEntity)

    fun clickCreateBtn()
}