package com.android.nasaapp.data.repository

import com.android.nasaapp.NasaApp
import com.android.nasaapp.data.DataEntity
import com.android.nasaapp.data.data_source.db.AppDao
import com.android.nasaapp.data.data_source.remote.RemoteDataSource
import com.android.nasaapp.network.ResultData
import com.android.nasaapp.utils.ConnectivityUtils
import com.android.nasaapp.utils.CustomException
import com.android.nasaapp.utils.getCurrentDateString

class AppRepositoryImpl (private val remoteDataSource: RemoteDataSource, private val appDao: AppDao) : AppRepository {

    private val isInternetOn = ConnectivityUtils.isInternetOn(NasaApp.appComponents.context())

    override suspend fun getApod(apiKey : String): ResultData<DataEntity> {

        val localData = appDao.getDataFromDb()
        if (!localData.isNullOrEmpty()) {

            if (getCurrentDateString().equals(localData[0])) {
                return ResultData.Success(localData[0])
            }
        }

        return if (isInternetOn) {
            when (val result = remoteDataSource.getApod(apiKey)) {
                is ResultData.Success -> {
                    val response = result.data
                    appDao.setDataInDb(response)
                    ResultData.Success(response)
                }
                is ResultData.Error -> {
                    ResultData.Error(CustomException("Remote Error"))
                }
            }
        } else {
            val localData = appDao.getDataFromDb()
            if (!localData.isNullOrEmpty()) {
                ResultData.Success(localData[0])
            } else {
                ResultData.Error(CustomException("Data Not Available"))
            }
        }
    }

}