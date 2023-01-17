package com.example.cft.domain.usecases

import com.example.cft.data.database.BinRepository
import javax.inject.Inject

class AddBinUseCase @Inject constructor(
    private val binRepository: BinRepository
) {
    suspend operator fun invoke(binValue: String){
        return binRepository.addBin(binValue)
    }
}