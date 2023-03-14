package com.mirzabek.noteappplaymarket.di
import com.mirzabek.noteappplaymarket.domain.usecase.NoteUseCase
import com.mirzabek.noteappplaymarket.domain.usecase.impl.NoteUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
interface NoteUSeCaseModule {

    @Binds
    fun bindNoteUseCase(noteUseCase: NoteUseCaseImpl): NoteUseCase

}