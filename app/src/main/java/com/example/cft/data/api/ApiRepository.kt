package com.example.cft.data.api

import com.example.cft.domain.models.Card

interface ApiRepository {

    suspend fun getCardInformation(bim: Int): Card
}