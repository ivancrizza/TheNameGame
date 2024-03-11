package com.example.thenamegame.data

import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface ApiService {
    @GET("v1.0/profiles")
    suspend fun getAllEmp(): Flow<List<TheNameResponse>>


}