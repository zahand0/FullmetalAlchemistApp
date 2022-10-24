package com.example.fullmetalalchemistapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.fullmetalalchemistapp.data.local.dao.HeroDao
import com.example.fullmetalalchemistapp.data.local.dao.HeroRemoteKeyDao
import com.example.fullmetalalchemistapp.domain.model.Hero
import com.example.fullmetalalchemistapp.domain.model.HeroRemoteKey
import com.example.models.MilitaryRank

@Database(
    entities = [Hero::class, HeroRemoteKey::class],
    version = 1
)
@TypeConverters(DatabaseConverter::class)
abstract class FullmetalAlchemistDatabase : RoomDatabase() {

    abstract fun heroDao(): HeroDao

    abstract fun heroRemoteKeyDao(): HeroRemoteKeyDao

}