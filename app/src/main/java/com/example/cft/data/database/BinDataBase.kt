package com.example.cft.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [BinEntity::class], version = BinDataBase.DB_VERSION)
abstract class BinDataBase(): RoomDatabase() {
    companion object{
        const val DB_VERSION = 1
        const val DB_NAME = "binsDB"
    }

    abstract fun binsDAO(): BinDAO
}