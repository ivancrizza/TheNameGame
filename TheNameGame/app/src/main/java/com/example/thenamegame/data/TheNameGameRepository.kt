package com.example.thenamegame.data

import kotlinx.coroutines.flow.Flow


interface TheNameGameRepository {
    suspend fun getAllEmpl(): Flow<List<TheNameResponse>>
}