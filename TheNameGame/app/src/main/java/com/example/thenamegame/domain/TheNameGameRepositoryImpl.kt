package com.example.thenamegame.domain

import com.example.thenamegame.data.ApiService
import com.example.thenamegame.data.TheNameGameRepository
import com.example.thenamegame.data.TheNameResponse
import kotlinx.coroutines.flow.Flow

class TheNameGameRepositoryImpl(
    val apiService: ApiService
) : TheNameGameRepository {

    override suspend fun getAllEmpl(): Flow<List<TheNameResponse>> = apiService.getAllEmp()

}