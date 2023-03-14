package com.mirzabek.noteappplaymarket.di

import com.mirzabek.noteappplaymarket.domain.repository.NoteAddRepository
import com.mirzabek.noteappplaymarket.domain.repository.impl.NoteAddRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
interface NoteAddRepositoryModule {
    @Binds
    fun bindNoteAddRepository(noteAddRepositoryImpl: NoteAddRepositoryImpl): NoteAddRepository
}