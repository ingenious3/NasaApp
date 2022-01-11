package com.android.nasaapp.data.data_source.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.android.nasaapp.data.DataEntity
import androidx.room.OnConflictStrategy.REPLACE

@Dao
interface AppDao {

    @Query("SELECT * FROM ${DataEntity.TABLE_NAME} ORDER BY ${DataEntity.DATE} DESC")
    suspend fun getDataFromDb(): List<DataEntity>

    @Insert(onConflict = REPLACE)
    suspend fun setDataInDb(dataEntity: DataEntity)

    @Query("DELETE FROM ${DataEntity.TABLE_NAME}")
    fun deleteAll()
}