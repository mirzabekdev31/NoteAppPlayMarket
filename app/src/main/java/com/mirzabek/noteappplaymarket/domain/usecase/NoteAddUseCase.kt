package com.mirzabek.noteappplaymarket.domain.usecase

import com.mirzabek.noteappplaymarket.data.sourse.room.entity.NotesEntity

interface NoteAddUseCase {

    fun insert(notesEntity: NotesEntity)
}