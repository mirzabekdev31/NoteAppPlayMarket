package com.mirzabek.noteappplaymarket.domain.repository.impl


import com.mirzabek.noteappplaymarket.data.sourse.room.AppDatabase
import com.mirzabek.noteappplaymarket.data.sourse.room.entity.NotesEntity
import com.mirzabek.noteappplaymarket.domain.repository.NoteRepository
import com.mirzabek.noteappplaymarket.navigation.Navigator
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    val appDatabase: AppDatabase,
    val navigation:Navigator
) :NoteRepository{

    override fun getAllNotes(): Flow<List<NotesEntity>> {
        return appDatabase.eventDao().getAllNotes()
    }

    override fun deleteNotes(notesEntity: NotesEntity) {
        appDatabase.eventDao().deleteNotes(notesEntity)
    }

    override fun updateNotes(notesEntity: NotesEntity) {
        appDatabase.eventDao().updateNotes(notesEntity)
    }

    override fun getNotesId(id: Int): Flow<NotesEntity> {
        return appDatabase.eventDao().getNotesId(id)
    }

    override fun getQueryNotes(query: String):Flow<List<NotesEntity>> {
        return appDatabase.eventDao().getSearchNotes(query)
    }
}