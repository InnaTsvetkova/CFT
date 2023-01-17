package com.example.cft.data.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiCountry(
    val numeric: String,
    val alpha2: String,
    val name: String,
    val emoji: String,
    val currency: String,
    val latitude: Int,
    val longitude: Int
)