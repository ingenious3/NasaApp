package com.android.nasaapp.di.module

import com.android.nasaapp.data.data_source.db.AppDao
import com.android.nasaapp.data.data_source.remote.RemoteDataSourceImpl
import com.android.nasaapp.data.repository.AppRepositoryImpl
import com.android.nasaapp.network.ApiInterface
import dagger.Module
import dagger.Provides
import org.jetbrains.annotations.NotNull
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    @NotNull
    fun getAppRepository(apiInterface: ApiInterface, appDao: AppDao): AppRepositoryImpl {
        val remoteDataSource = RemoteDataSourceImpl(apiInterface)
        return AppRepositoryImpl(remoteDataSource, appDao)
    }
}