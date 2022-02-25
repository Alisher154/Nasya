package uz.texnopos.nasya.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.texnopos.nasya.repository.impl.ClientsRepositoryImpl
import uz.texnopos.nasya.repository.interfaces.ClientsRepository
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @[Binds Singleton]
    fun provideClientsRepository(impl: ClientsRepositoryImpl): ClientsRepository

}