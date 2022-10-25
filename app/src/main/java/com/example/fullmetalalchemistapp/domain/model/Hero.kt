package com.example.fullmetalalchemistapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.fullmetalalchemistapp.util.Constants.HERO_DATABASE_TABLE
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = HERO_DATABASE_TABLE)
data class Hero(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String,
    val image: String,
    val memorableQuotes: List<String>,
    val alias: String,
    val rating: Double,
    val about: String,
    val species: String,
    val militaryRank: MilitaryRank,
    val abilities: List<String>,
    val weapons: List<String>
)