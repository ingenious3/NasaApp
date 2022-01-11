package com.android.nasaapp.di.module

import com.android.nasaapp.network.ApiInterface
import com.android.nasaapp.utils.Constants
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@Suppress("unused")
class ApiClientModule {

    @Provides
    @Singleton
    fun getApiClient(gsonConverterFactory: GsonConverterFactory, okHttpClient: OkHttpClient) : Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Provides
    @Singleton
    fun getOkHttpClient() : OkHttpClient {
        return OkHttpClient().newBuilder()
            .addInterceptor(HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
    }

    @Provides
    @Singleton
    fun getGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Provides
    @Singleton
    fun getApiInterface(retrofit: Retrofit): ApiInterface = retrofit.create(ApiInterface::class.java)

}