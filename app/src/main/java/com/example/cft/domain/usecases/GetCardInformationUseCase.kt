package com.example.cft.domain.usecases

import com.example.cft.data.api.ApiRepository
import com.example.cft.domain.models.Card
import javax.inject.Inject

class GetCardInformationUseCase @Inject constructor(
    private val apiRepository: ApiRepository

){
    suspend operator fun invoke(bin: Int) : Card {
        return apiRepository.getCardInformation(bin)
    }
}