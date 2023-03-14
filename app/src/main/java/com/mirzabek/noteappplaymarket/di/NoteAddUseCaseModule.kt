package com.mirzabek.noteappplaymarket.di

import com.mirzabek.noteappplaymarket.domain.usecase.NoteAddUseCase
import com.mirzabek.noteappplaymarket.domain.usecase.impl.NoteAddUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface NoteAddUseCaseModule {


    @Binds
    fun bindNoteAddUseCase(noteAddUseCase: NoteAddUseCaseImpl): NoteAddUseCase
}