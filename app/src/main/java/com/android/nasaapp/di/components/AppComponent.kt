package com.android.nasaapp.di.components

import android.content.Context
import com.android.nasaapp.data.data_source.db.AppDao
import com.android.nasaapp.data.data_source.db.AppDb
import com.android.nasaapp.di.module.*
import com.android.nasaapp.ui.MainActivity
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [ApiClientModule::class, RepositoryModule::class, DbModule::class, AppModule::class, ViewModelModule::class])
interface AppComponent {

    fun inject(MainActivity: MainActivity)

    fun context(): Context

    fun retrofit(): Retrofit

    fun appDao(): AppDao

    fun appDatabase(): AppDb
}
