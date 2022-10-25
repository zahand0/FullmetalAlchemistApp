package com.example.fullmetalalchemistapp.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.fullmetalalchemistapp.data.local.FullmetalAlchemistDatabase
import com.example.fullmetalalchemistapp.util.Constants.FULLMETAL_ALCHEMIST_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): RoomDatabase {
        return Room.databaseBuilder(
            context,
            FullmetalAlchemistDatabase::class.java,
            FULLMETAL_ALCHEMIST_DATABASE
        ).build()
    }

}