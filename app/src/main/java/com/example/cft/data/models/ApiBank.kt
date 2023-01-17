package com.example.cft.data.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiBank(
    val name: String,
    val url: String,
    val phone: String,
    val city: String
)