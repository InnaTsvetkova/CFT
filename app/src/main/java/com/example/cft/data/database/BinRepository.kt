package com.example.cft.data.database

import com.example.cft.domain.models.Bin
import kotlinx.coroutines.flow.Flow

interface BinRepository {

    suspend fun addBin(bin: String)

    suspend fun getBins(): Flow<List<Bin>>


}