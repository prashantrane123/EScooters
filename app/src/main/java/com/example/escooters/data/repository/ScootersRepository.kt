package com.example.escooters.data.repository

import android.util.Log
import com.example.escooters.data.model.ScootersResponse
import com.example.escooters.network.api.ScootersApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class ScootersRepository
    @Inject
    constructor() {
        private val scootersApi: ScootersApi = provideScooterApi(providesRetrofit())

        suspend fun getScooters(): Flow<ScootersResponse> =
            flow {
                Log.d("Api", "Calling")
                val response = scootersApi.getScooters()
                if (response.isSuccessful) {
                    response.body()?.let { emit(it) }
                }
            }

        private fun providesRetrofit(): Retrofit =
            Retrofit
                .Builder()
                .baseUrl("https://storage.googleapis.com/voi-android-technical-interview/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        private fun provideScooterApi(retrofit: Retrofit): ScootersApi = retrofit.create(ScootersApi::class.java)
    }
