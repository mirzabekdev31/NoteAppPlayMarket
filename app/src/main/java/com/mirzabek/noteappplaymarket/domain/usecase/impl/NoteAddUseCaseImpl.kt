package com.mirzabek.noteappplaymarket.domain.usecase.impl

import com.mirzabek.noteappplaymarket.data.sourse.room.entity.NotesEntity
import com.mirzabek.noteappplaymarket.domain.repository.NoteAddRepository
import com.mirzabek.noteappplaymarket.domain.usecase.NoteAddUseCase
import javax.inject.Inject

class NoteAddUseCaseImpl @Inject constructor(
    val reposiroty:NoteAddRepository
):NoteAddUseCase{
    override fun insert(notesEntity: NotesEntity) {
        reposiroty.insertNotes(notesEntity)
    }
}