package com.example.cft.data.mapper

import com.example.cft.data.models.ApiCard
import com.example.cft.domain.models.Card
import javax.inject.Inject

class CardMapper @Inject constructor(
    private val countryMapper: CountryMapper,
    private val bankMapper: BankMapper,
    private val numberCardMapper: NumberCardMapper

) : BaseMapper<ApiCard, Card>(){

    override fun transform(entity: ApiCard) = Card(
        number = numberCardMapper.transform(entity.number),
        scheme = entity.scheme,
        type = entity.type,
        brand = entity.brand,
        prepaid = entity.prepaid,
        country = countryMapper.transform(entity.country),
        bank = bankMapper.transform(entity.bank)
    )
}