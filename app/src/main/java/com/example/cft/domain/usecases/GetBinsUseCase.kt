package com.example.cft.domain.usecases

import com.example.cft.data.database.BinRepository
import com.example.cft.domain.models.Bin
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetBinsUseCase @Inject constructor(
    private val binRepository: BinRepository

) {
    suspend operator fun invoke(): Flow<List<Bin>>{
        return binRepository.getBins()
    }
}