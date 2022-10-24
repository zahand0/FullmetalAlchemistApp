package com.example.fullmetalalchemistapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.fullmetalalchemistapp.data.local.dao.HeroDao
import com.example.fullmetalalchemistapp.domain.model.Hero
import com.example.models.MilitaryRank
import com.example.models.Species

@Database(entities = [Hero::class, MilitaryRank::class, Species::class], version = 1)
abstract class FullmetalAlchemistDatabase: RoomDatabase() {

    abstract fun heroDao(): HeroDao

}