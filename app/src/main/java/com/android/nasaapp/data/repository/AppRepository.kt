package com.android.nasaapp.data.repository

import com.android.nasaapp.data.DataEntity
import com.android.nasaapp.network.ResultData

interface AppRepository {

    suspend fun getApod(apiKey: String) : ResultData<DataEntity>
}