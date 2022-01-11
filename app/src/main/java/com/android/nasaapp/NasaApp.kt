package com.android.nasaapp

import android.app.Application
import com.android.nasaapp.di.components.AppComponent
import com.android.nasaapp.di.components.DaggerAppComponent
import com.android.nasaapp.di.module.AppModule
import com.android.nasaapp.di.module.DbModule

class NasaApp: Application() {

    companion object {
        lateinit var appComponents: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponents = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .dbModule(DbModule(this))
            .build()
    }


}