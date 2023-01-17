package com.example.cft.data.database

import com.example.cft.data.mapper.BinMapper
import com.example.cft.domain.models.Bin
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class BinRepositoryImpl @Inject constructor(
    private val binMapper: BinMapper,
    private val binDAO: BinDAO
) : BinRepository {
    override suspend fun addBin(bin: String) {
        return binDAO.addBin(BinEntity(valueBin = bin))
    }

    override suspend fun getBins(): Flow<List<Bin>> {
        return binDAO.getBins().map{
            binMapper.transform(it)
        }
    }


}