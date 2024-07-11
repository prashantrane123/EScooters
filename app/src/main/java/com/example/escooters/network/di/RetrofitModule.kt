/*
package com.example.escooters.network.di

import com.example.escooters.network.api.ScootersApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {
    @Provides
    fun providesBaseUrl(): String = "https://storage.googleapis.com/voi-android-technical-interview/"

    @Provides
    fun providesRetrofit(baseUrl: String): Retrofit =
        Retrofit
            .Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

*/
/*
    @Provides
    fun provideScooterApi(retrofit: Retrofit): ScootersApi = retrofit.create(ScootersApi::class.java)
*//*



}
*/
