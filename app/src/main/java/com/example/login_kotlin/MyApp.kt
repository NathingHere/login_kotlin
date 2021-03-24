package com.example.login_kotlin

import android.app.Application
import com.example.login_kotlin.koin.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApp)
            androidLogger()
            modules(listOf(viewModelModule))
        }
    }

}