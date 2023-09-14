package com.example.data.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import javax.inject.Singleton

@Singleton
class ApiManager {
    private val BASE_URL = "https://run.mocky.io/v3/"

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getApi(): Api {
        return getRetrofit().create(Api::class.java)
    }
}
