package com.example.cft.data.mapper

import com.example.cft.data.database.BinEntity
import com.example.cft.data.mapper.BaseMapper
import com.example.cft.domain.models.Bin
import javax.inject.Inject

class BinMapper @Inject constructor(

) : BaseMapper<BinEntity, Bin>() {
    override fun transform(entity: BinEntity) = Bin(
        id = entity.id,
        valueBin = entity.valueBin
    )
}