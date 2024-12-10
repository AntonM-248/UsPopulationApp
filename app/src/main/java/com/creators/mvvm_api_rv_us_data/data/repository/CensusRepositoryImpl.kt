package com.creators.mvvm_api_rv_us_data.data.repository

import com.creators.mvvm_api_rv_us_data.data.api.CensusApi
import com.creators.mvvm_api_rv_us_data.data.model.PopulationResponse

class CensusRepositoryImpl constructor (
    private val censusApi: CensusApi
) : CensusRepository {
    override suspend fun getPopulationData(): PopulationResponse {
        return censusApi.fetchPopulationData()
    }
}