package com.android.nasaapp.data.data_source.remote

import com.android.nasaapp.data.DataEntity
import com.android.nasaapp.network.ApiInterface
import com.android.nasaapp.network.ResultData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RemoteDataSourceImpl (private val apiInterface: ApiInterface) : RemoteDataSource {

    override suspend fun getApod(apiKey: String) : ResultData<DataEntity> {
        return  withContext(Dispatchers.IO) {
            val request = apiInterface.getApod( apiKey)
            ResultData.Success(request)
        }
    }
}

