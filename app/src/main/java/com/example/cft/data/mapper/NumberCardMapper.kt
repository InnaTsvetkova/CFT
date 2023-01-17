package com.example.cft.data.mapper

import com.example.cft.data.models.ApiNumberCard
import com.example.cft.domain.models.NumberCard
import javax.inject.Inject

class NumberCardMapper @Inject constructor(

): BaseMapper<ApiNumberCard, NumberCard>() {
    override fun transform(entity: ApiNumberCard) = NumberCard (
        length = entity.length,
        luhn = entity.luhn
    )
}