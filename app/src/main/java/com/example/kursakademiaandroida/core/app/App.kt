package com.example.kursakademiaandroida.core.app

import android.app.Application
import com.example.kursakademiaandroida.core.app.di.koinInjector
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

// remember to define android:name=.. in manifest xml
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        //initialization of Koin
        startKoin()
    }

    private fun startKoin() {
        startKoin {
            androidContext(this@App) //pass application context
            modules(koinInjector) //define modules
        }
    }
}