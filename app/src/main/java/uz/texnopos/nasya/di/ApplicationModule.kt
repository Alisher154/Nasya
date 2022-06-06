package uz.texnopos.nasya.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.texnopos.nasya.domain.usecase.util.MailMatcher
import uz.texnopos.nasya.utils.AndroidMailMatcher

import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Provides
    @Singleton
    fun provideMailMatcher(): MailMatcher = AndroidMailMatcher()
}