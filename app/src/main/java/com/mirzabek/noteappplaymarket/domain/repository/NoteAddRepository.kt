package com.mirzabek.noteappplaymarket.domain.repository

import com.mirzabek.noteappplaymarket.data.sourse.room.entity.NotesEntity

interface NoteAddRepository {

    fun insertNotes(notesEntity: NotesEntity)

}