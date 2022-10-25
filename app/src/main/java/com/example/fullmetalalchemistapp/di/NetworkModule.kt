package com.example.fullmetalalchemistapp.di

import androidx.paging.ExperimentalPagingApi
import com.example.fullmetalalchemistapp.data.local.FullmetalAlchemistDatabase
import com.example.fullmetalalchemistapp.data.remote.FullmetalAlchemistApi
import com.example.fullmetalalchemistapp.data.repository.RemoteDataSourceImpl
import com.example.fullmetalalchemistapp.domain.repository.RemoteDataSource
import com.example.fullmetalalchemistapp.util.Constants.BASE_URL
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@ExperimentalPagingApi
@ExperimentalSerializationApi
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofitInstance(okHttpClient: OkHttpClient): Retrofit {
        val contentType = "application/json".toMediaType()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(Json.asConverterFactory(contentType))
            .build()
    }

    @Provides
    @Singleton
    fun provideFullmetalAlchemistApi(retrofit: Retrofit): FullmetalAlchemistApi {
        return retrofit.create(FullmetalAlchemistApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRemoteDataSource(
        fullmetalAlchemistApi: FullmetalAlchemistApi,
        fullmetalAlchemistDatabase: FullmetalAlchemistDatabase
    ): RemoteDataSource {
        return RemoteDataSourceImpl(
            fullmetalAlchemistApi = fullmetalAlchemistApi,
            fullmetalAlchemistDatabase = fullmetalAlchemistDatabase
        )
    }
}