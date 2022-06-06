package uz.texnopos.nasya.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import uz.texnopos.nasya.data.local.room.NasyaDao
import uz.texnopos.nasya.data.local.room.NasyaDatabase
import uz.texnopos.nasya.data.local.sharedpref.SharedPref
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class LocalModule {

    @[Provides Singleton]
    fun provideSharedPreference(@ApplicationContext context: Context): SharedPref =
        SharedPref(context)

    @[Provides Singleton]
    fun provideNasyaDatabase(
        @ApplicationContext context: Context
    ): NasyaDatabase = Room.databaseBuilder(
        context,
        NasyaDatabase::class.java,
        "nasya_database.db"
    )
        .build()

    @[Provides Singleton]
    fun provideLeagueDao(db: NasyaDatabase): NasyaDao =
        db.dao()
}