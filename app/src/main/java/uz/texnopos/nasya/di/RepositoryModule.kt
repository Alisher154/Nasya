package uz.texnopos.nasya.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.texnopos.nasya.data.repository.ClientRepositoryImpl
import uz.texnopos.nasya.data.repository.ProductRepositoryImpl
import uz.texnopos.nasya.domain.repository.ClientRepository
import uz.texnopos.nasya.domain.repository.ProductRepository
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @[Binds Singleton]
    fun provideClientRepository(impl: ClientRepositoryImpl): ClientRepository

    @[Binds Singleton]
    fun provideProductRepository(impl: ProductRepositoryImpl): ProductRepository

}