package com.example.thenamegame.data

import okhttp3.OkHttpClient
import retrofit2.Retrofit

object RetrofitService {
    private const val BASE_URL = " https://namegame.willowtreeapps.com/api"
    val logger = OkHttpClient.Builder()
        .build()
    val apiService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(logger)
        .build()
        .create(ApiService::class.java)

}