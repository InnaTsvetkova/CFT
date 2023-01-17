package com.example.cft.di

import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import com.example.cft.data.api.ApiService
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import java.util.logging.Handler

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideMoshi(): Moshi {
        return Moshi.Builder().build()
    }

    @Provides
    fun provideApiHttpClient(): OkHttpClient{
        return OkHttpClient.Builder().build()
    }

    @Provides
    fun provideApiRetrofit(moshi: Moshi, client: OkHttpClient): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://lookup.binlist.net/")
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

    }

    @Provides
    fun provideApiService(retrofit: Retrofit) : ApiService {
        return retrofit.create()
    }
}