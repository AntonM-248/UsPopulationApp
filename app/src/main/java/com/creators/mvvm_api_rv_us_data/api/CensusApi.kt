package com.creators.mvvm_api_rv_us_data.api

import com.creators.mvvm_api_rv_us_data.model.PopulationResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



object CensusApi {
    private val apiService: ApiService by lazy {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()

        Retrofit.Builder()
            .baseUrl("https://datausa.io/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(ApiService::class.java)
    }

    // Fetch Population Data
    suspend fun fetchPopulationData(): PopulationResponse {
        return apiService.getPopulationData()
    }
}
