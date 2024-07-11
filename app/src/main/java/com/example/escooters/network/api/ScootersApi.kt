package com.example.escooters.network.api

import com.example.escooters.screen.data.model.ScootersResponse
import retrofit2.Response
import retrofit2.http.GET

interface ScootersApi {
    @GET("scooters.json")
    suspend fun getScooters(): Response<ScootersResponse>
}
