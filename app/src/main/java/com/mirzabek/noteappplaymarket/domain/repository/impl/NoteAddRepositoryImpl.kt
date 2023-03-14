package com.mirzabek.noteappplaymarket.domain.repository.impl

import com.mirzabek.noteappplaymarket.data.sourse.room.AppDatabase
import com.mirzabek.noteappplaymarket.data.sourse.room.entity.NotesEntity
import com.mirzabek.noteappplaymarket.domain.repository.NoteAddRepository
import javax.inject.Inject

class NoteAddRepositoryImpl @Inject constructor(
    val appData:AppDatabase
) :NoteAddRepository{
    override fun insertNotes(notesEntity: NotesEntity) {

        appData.eventDao().insert(notesEntity)
    }
}