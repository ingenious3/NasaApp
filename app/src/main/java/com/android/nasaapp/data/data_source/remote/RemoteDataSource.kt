package com.android.nasaapp.data.data_source.remote

import com.android.nasaapp.data.DataEntity
import com.android.nasaapp.network.ResultData

interface RemoteDataSource {

    suspend fun getApod(apiKey: String) : ResultData<DataEntity>
}