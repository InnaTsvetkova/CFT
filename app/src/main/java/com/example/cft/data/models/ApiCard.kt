package com.example.cft.data.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiCard(
    val number: ApiNumberCard,
    val scheme: String,
    val type: String,
    val brand: String,
    val prepaid: Boolean,
    val country: ApiCountry,
    val bank: ApiBank
)