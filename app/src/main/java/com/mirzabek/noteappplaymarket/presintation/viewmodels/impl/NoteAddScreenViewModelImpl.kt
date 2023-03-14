package com.mirzabek.noteappplaymarket.presintation.viewmodels.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mirzabek.noteappplaymarket.data.sourse.room.entity.NotesEntity
import com.mirzabek.noteappplaymarket.domain.usecase.NoteAddUseCase
import com.mirzabek.noteappplaymarket.presintation.viewmodels.NoteAddScreenViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteAddScreenViewModelImpl @Inject constructor(
    val noteAddUseCase: NoteAddUseCase
) :NoteAddScreenViewModel,ViewModel(){
    override val addNotes=MutableSharedFlow<Unit>()

    override fun insertNote(notesEntity: NotesEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            noteAddUseCase.insert(notesEntity)
        }
    }

    override fun clickCreateBtn() {
        viewModelScope.launch {
            addNotes.emit(Unit)
        }
    }
}