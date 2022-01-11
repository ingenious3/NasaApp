package com.android.nasaapp.di.module

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.android.nasaapp.data.data_source.db.AppDao
import com.android.nasaapp.data.data_source.db.AppDb
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
@Suppress("unused")
class DbModule(private val application: Application) {

    @Singleton
    @Provides
    fun provideAppDb(context: Context): AppDb {
        return Room.databaseBuilder(context.applicationContext, AppDb::class.java, "nasa_db").build()
    }

    @Singleton
    @Provides
    fun providesAppDao(appDb: AppDb): AppDao {
        return appDb.appDao()
    }
}