package com.example.fullmetalalchemistapp.domain.repository

import kotlinx.coroutines.flow.Flow

interface DataStoreOperations {

    suspend fun saveOnBoardingPage(completed: Boolean)

    fun readOnBoardingState(): Flow<Boolean>
}