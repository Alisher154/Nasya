package uz.texnopos.nasya.di

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import uz.texnopos.nasya.BuildConfig

@HiltAndroidApp
class App:Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG)
            Timber.plant(Timber.DebugTree())
    }
}