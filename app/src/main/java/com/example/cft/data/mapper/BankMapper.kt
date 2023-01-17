package com.example.cft.data.mapper

import com.example.cft.data.models.ApiBank
import com.example.cft.domain.models.Bank
import javax.inject.Inject

class BankMapper @Inject constructor(

) : BaseMapper<ApiBank, Bank>(){
    override fun transform(entity: ApiBank) = Bank (
        name = entity.name,
        url = entity.url,
        phone = entity.phone,
        city = entity.city
    )
}