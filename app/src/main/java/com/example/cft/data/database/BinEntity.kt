package com.example.cft.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bins")
data class BinEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val valueBin: String
)