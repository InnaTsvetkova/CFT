package com.example.cft.data.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiNumberCard(
    val length: Int,
    val luhn: Boolean
)