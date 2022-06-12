package com.uznewmax.clients.di

import com.uznewmax.clients.api.ClientRepository
import com.uznewmax.clients.impl.ClientRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @[Binds Singleton]
    fun provideClientRepository(impl: ClientRepositoryImpl): ClientRepository


}