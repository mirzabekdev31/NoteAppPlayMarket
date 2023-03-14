package com.mirzabek.noteappplaymarket.di

import com.mirzabek.noteappplaymarket.domain.repository.NoteRepository
import com.mirzabek.noteappplaymarket.domain.repository.impl.NoteRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface NoteRepositoryModule {
    @Binds
    fun bindNoteRepository(appRepositoryImpl: NoteRepositoryImpl): NoteRepository
}