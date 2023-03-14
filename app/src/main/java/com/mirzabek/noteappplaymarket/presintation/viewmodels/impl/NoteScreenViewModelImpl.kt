package com.mirzabek.noteappplaymarket.presintation.viewmodels.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mirzabek.noteappplaymarket.data.sourse.room.entity.NotesEntity
import com.mirzabek.noteappplaymarket.domain.usecase.NoteUseCase
import com.mirzabek.noteappplaymarket.presintation.viewmodels.NoteScreenViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class NoteScreenViewModelImpl @Inject constructor(
    private val noteUseCase: NoteUseCase,
):NoteScreenViewModel,ViewModel(){
    override val openNoteAddScreen=MutableSharedFlow<Unit>()

    init {
        getAllNotes()
    }

    override fun getAllNotes(): Flow<List<NotesEntity>> {
        return noteUseCase.getAllNotes()
    }

    override fun clickAddButton() {
        viewModelScope.launch {
            openNoteAddScreen.emit(Unit)
        }
    }

    override fun deleteNotes(notesEntity: NotesEntity) {
        viewModelScope.launch (Dispatchers.IO){
            noteUseCase.deleteNotes(notesEntity)
        }
    }

    override fun updateNotes(notesEntity: NotesEntity) {
        viewModelScope.launch (Dispatchers.IO){
            noteUseCase.updateNotes(notesEntity)
        }
    }

    override fun getQueryNotes(query: String) :Flow<List<NotesEntity>>{
        return noteUseCase.getQueryNotes(query)
    }
}