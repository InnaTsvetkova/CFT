package com.example.cft.di

import com.example.cft.data.api.ApiRepository
import com.example.cft.data.api.ApiRepositoryImpl
import com.example.cft.data.database.BinRepository
import com.example.cft.data.database.BinRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindApiRepository(apiRepositoryImpl: ApiRepositoryImpl) : ApiRepository

    @Binds
    abstract fun bindBinRepository(binRepositoryImpl: BinRepositoryImpl) : BinRepository
}