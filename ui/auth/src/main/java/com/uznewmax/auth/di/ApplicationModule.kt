package com.uznewmax.auth.di

import com.uznewmax.auth.usecase.utils.AndroidMailMatcher
import com.uznewmax.auth.usecase.utils.MailMatcher
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Provides
    @Singleton
    fun provideMailMatcher(): MailMatcher = AndroidMailMatcher()
}