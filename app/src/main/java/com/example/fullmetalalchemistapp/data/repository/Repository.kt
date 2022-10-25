package com.example.fullmetalalchemistapp.data.repository

import androidx.paging.PagingData
import com.example.fullmetalalchemistapp.domain.model.Hero
import com.example.fullmetalalchemistapp.domain.repository.DataStoreOperations
import com.example.fullmetalalchemistapp.domain.repository.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val dataStore: DataStoreOperations,
    private val remote: RemoteDataSource
) {

    fun getAllHeroes(): Flow<PagingData<Hero>> {
        return remote.getAllHeroes()
    }

    suspend fun saveOnBoardingState(completed: Boolean) {
        dataStore.saveOnBoardingState(completed)
    }

    fun readOnBoardingState(): Flow<Boolean> {
        return dataStore.readOnBoardingState()
    }
}