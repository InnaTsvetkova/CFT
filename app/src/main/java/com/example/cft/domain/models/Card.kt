package com.example.cft.domain.models


data class Card(
    val number: NumberCard,
    val scheme: String,
    val type: String,
    val brand: String,
    val prepaid: Boolean,
    val country: Country,
    val bank: Bank
)