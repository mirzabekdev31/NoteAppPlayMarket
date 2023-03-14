package com.mirzabek.noteappplaymarket.presintation.viewmodels

import com.mirzabek.noteappplaymarket.data.sourse.room.entity.NotesEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharedFlow

interface NoteEditScreenViewModel {

    val backFlow:SharedFlow<Unit>

    fun updateNotes(notesEntity: NotesEntity)

    fun getNotesId(id:Int):Flow<NotesEntity>

    fun back()

}