package uz.texnopos.nasya.di

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class App:Application() {
    companion object {
        lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()
        if (uz.texnopos.nasya.BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        instance = this

    }
}