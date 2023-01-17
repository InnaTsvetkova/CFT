package com.example.cft.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BinDAO {

    @Insert
    suspend fun addBin(bin: BinEntity)

    @Query("SELECT * FROM bins")
    fun getBins(): Flow<List<BinEntity>>



}