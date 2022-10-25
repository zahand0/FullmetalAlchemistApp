package com.example.fullmetalalchemistapp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class MilitaryRank(
    val type: String,
    val rankName: String,
    val img: String
)
