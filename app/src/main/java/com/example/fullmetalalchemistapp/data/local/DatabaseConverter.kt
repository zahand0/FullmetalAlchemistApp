package com.example.fullmetalalchemistapp.data.local

import androidx.room.TypeConverter
import com.example.models.MilitaryRank

class DatabaseConverter {

    private val separator = "*#*"

    @TypeConverter
    fun convertListToString(list: List<String>): String {
        val stringBuilder = StringBuilder()
        for (item in list) {
            stringBuilder.append(item).append(separator)
        }
        stringBuilder.setLength(stringBuilder.length - separator.length)
        return stringBuilder.toString()
    }

    @TypeConverter
    fun convertStringToList(string: String): List<String> {
        return string.split(separator)
    }

    @TypeConverter
    fun convertMilitaryRankToString(rank: MilitaryRank): String {
        return StringBuilder()
            .append(rank.rankName)
            .append(separator)
            .append(rank.img)
            .toString()
    }

    @TypeConverter
    fun convertStringToMilitaryRank(string: String): MilitaryRank {
        val stringData = string.split(separator)
        return MilitaryRank (stringData[0], stringData[1])
    }
}