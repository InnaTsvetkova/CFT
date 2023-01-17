package com.example.cft.data.api

import com.example.cft.data.api.ApiRepository
import com.example.cft.data.api.ApiService
import com.example.cft.data.mapper.CardMapper
import com.example.cft.domain.models.Card
import javax.inject.Inject

class ApiRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val cardMapper: CardMapper

) : ApiRepository {

    override suspend fun getCardInformation(bin: Int): Card {
        val apiCard = apiService.getCardInformation(bin)
        return cardMapper.transform(apiCard)
    }
}