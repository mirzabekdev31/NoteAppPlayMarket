package com.mirzabek.noteappplaymarket.domain.usecase.impl

import com.mirzabek.noteappplaymarket.data.sourse.room.entity.NotesEntity
import com.mirzabek.noteappplaymarket.domain.repository.NoteRepository
import com.mirzabek.noteappplaymarket.domain.usecase.NoteUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NoteUseCaseImpl @Inject constructor(
    val repository: NoteRepository
) :NoteUseCase{
    override fun getAllNotes(): Flow<List<NotesEntity>> {
        return repository.getAllNotes()
    }

    override fun deleteNotes(notesEntity: NotesEntity) {
        repository.deleteNotes(notesEntity)
    }

    override fun updateNotes(notesEntity: NotesEntity) {
        repository.updateNotes(notesEntity)
    }

    override fun getNotesId(id: Int): Flow<NotesEntity> {
        return repository.getNotesId(id)
    }

    override fun getQueryNotes(query: String): Flow<List<NotesEntity>> {
        return repository.getQueryNotes(query)
    }
}