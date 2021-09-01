package com.example.autolivtest

import android.app.Application
import com.example.autolivtest.di.networkModule
import com.example.autolivtest.di.serviceModule
import com.example.autolivtest.di.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class AutolivApp : Application() {

    override fun onCreate() {
        super.onCreate()

        //start Koin
        startKoin {
            androidContext(this@AutolivApp)
            modules(networkModule, serviceModule, viewModelsModule)
        }
    }
}