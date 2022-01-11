package com.android.nasaapp.network

import com.android.nasaapp.data.DataEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

//    https://api.nasa.gov/planetary/apod?api_key=Gf3eKlPzEp8XgkImHek7jGbPNG4VrtYnyYUNdoh8

    @GET("planetary/apod")
    suspend fun getApod(@Query("api_key") apiKey : String) : DataEntity

}