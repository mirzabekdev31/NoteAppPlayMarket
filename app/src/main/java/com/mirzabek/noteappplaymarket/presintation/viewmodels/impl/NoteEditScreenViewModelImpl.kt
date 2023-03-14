package com.mirzabek.noteappplaymarket.presintation.viewmodels.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mirzabek.noteappplaymarket.data.sourse.room.entity.NotesEntity
import com.mirzabek.noteappplaymarket.domain.usecase.NoteUseCase
import com.mirzabek.noteappplaymarket.presintation.viewmodels.NoteEditScreenViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteEditScreenViewModelImpl @Inject constructor(
    val noteUseCase: NoteUseCase
) :NoteEditScreenViewModel,ViewModel(){
    override val backFlow= MutableSharedFlow<Unit>()

    override fun updateNotes(notesEntity: NotesEntity) {
        noteUseCase.updateNotes(notesEntity)
    }

    override fun getNotesId(id: Int): Flow<NotesEntity> {
        return noteUseCase.getNotesId(id)
    }

    override fun back() {
        viewModelScope.launch {
            backFlow.emit(Unit)
        }
    }
}