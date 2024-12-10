package com.creators.mvvm_api_rv_us_data.data.api

import com.creators.mvvm_api_rv_us_data.data.model.PopulationResponse
import retrofit2.http.GET

interface ApiService {
    @GET("data?drilldowns=Nation&measures=Population")
    suspend fun getPopulationData(): PopulationResponse
}