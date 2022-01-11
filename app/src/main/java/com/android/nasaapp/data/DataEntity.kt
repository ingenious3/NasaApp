package com.android.nasaapp.data

import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import org.jetbrains.annotations.NotNull

@Entity(tableName = DataEntity.TABLE_NAME, primaryKeys = ["url"])
data class DataEntity(

    @SerializedName("copyright")
    val copyright: String?,

    @SerializedName("date")
    val date: String?,

    @SerializedName("explanation")
    val explanation: String?,

    @SerializedName("hdurl")
    val hdurl: String?,

    @SerializedName("media_type")
    val mediaType: String?,

    @SerializedName("service_version")
    val serviceVersion: String?,

    @SerializedName("title")
    val title: String?,

    @NotNull
    @SerializedName("url")
    val url: String
) {
    companion object {
        const val TABLE_NAME = "AppDbEntity"
        const val DATE = "date"
    }
}
