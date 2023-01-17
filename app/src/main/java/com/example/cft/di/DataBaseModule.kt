package com.example.cft.di

import android.content.Context
import androidx.room.Room
import com.example.cft.data.database.BinDAO
import com.example.cft.data.database.BinDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    fun provideBinDB(@ApplicationContext context: Context): BinDataBase {
        return Room.databaseBuilder(
            context,
            BinDataBase::class.java,
            BinDataBase.DB_NAME
        ).build()
    }

    @Provides
    fun provideBinDAO(dataBase: BinDataBase): BinDAO{
        return dataBase.binsDAO()
    }
}