package com.example.cft.data.mapper

import com.example.cft.data.models.ApiCountry
import com.example.cft.domain.models.Country
import javax.inject.Inject

class CountryMapper @Inject constructor(

) : BaseMapper<ApiCountry, Country>(){

    override fun transform(entity: ApiCountry) = Country (
        numeric = entity.numeric,
        alpha2 = entity.alpha2,
        name = entity.name,
        emoji = entity.emoji,
        currency = entity.currency,
        latitude = entity.latitude,
        longitude = entity.longitude
    )
}