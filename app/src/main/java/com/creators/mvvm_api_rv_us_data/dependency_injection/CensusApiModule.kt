package com.creators.mvvm_api_rv_us_data.dependency_injection

import com.creators.mvvm_api_rv_us_data.data.api.CensusApi
import com.creators.mvvm_api_rv_us_data.data.repository.CensusRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class CensusApiModule {

    @Provides
    fun provideCensusApi(): CensusApi {
        return CensusApi()
    }

    @Provides
    fun provideCensusRepository(): CensusRepositoryImpl{
        return CensusRepositoryImpl(provideCensusApi())
    }
}