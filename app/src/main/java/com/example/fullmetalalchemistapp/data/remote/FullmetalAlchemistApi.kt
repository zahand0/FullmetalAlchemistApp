package com.example.fullmetalalchemistapp.data.remote

import com.example.fullmetalalchemistapp.domain.model.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface FullmetalAlchemistApi {

    @GET("/fma/heroes")
    suspend fun getAllHeroes(
        @Query("page") page: Int = 0
    ): ApiResponse

    @GET("/fma/heroes/search")
    suspend fun searchHeroes(
        @Query("name") name: String
    ): ApiResponse

}