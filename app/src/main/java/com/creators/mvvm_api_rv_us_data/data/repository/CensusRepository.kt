package com.creators.mvvm_api_rv_us_data.data.repository

import com.creators.mvvm_api_rv_us_data.data.model.PopulationResponse

interface CensusRepository {
    suspend fun getPopulationData(): PopulationResponse
}