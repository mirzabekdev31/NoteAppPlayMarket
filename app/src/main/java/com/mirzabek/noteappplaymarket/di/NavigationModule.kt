package com.mirzabek.noteappplaymarket.di

import com.mirzabek.noteappplaymarket.navigation.NavigationDispatcher
import com.mirzabek.noteappplaymarket.navigation.NavigationHandler
import com.mirzabek.noteappplaymarket.navigation.Navigator
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
interface NavigationModule {

    @[Binds Singleton]
    fun bindNavigator(navigationDispatcher: NavigationDispatcher): Navigator

    @[Binds Singleton]
    fun bindNavigationHandler(navigationDispatcher: NavigationDispatcher): NavigationHandler

}