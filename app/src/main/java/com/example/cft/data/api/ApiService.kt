package com.example.cft.data.api

import com.example.cft.data.models.ApiCard
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("{bin}")
    suspend fun getCardInformation(
        @Path("bin") bin: Int
    ) : ApiCard

}