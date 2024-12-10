package com.creators.mvvm_api_rv_us_data.ui.view_model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.creators.mvvm_api_rv_us_data.data.model.PopulationData
import com.creators.mvvm_api_rv_us_data.data.repository.CensusRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PopulationViewModel @Inject constructor(
    private val censusRepository: CensusRepositoryImpl
): ViewModel() {

    private val TAG = "ViewModel"

    private val _populationData = MutableLiveData<List<PopulationData>>()

    val populationData: LiveData<List<PopulationData>> get() = _populationData

    fun getPopulationData() {
        viewModelScope.launch {
            try {
                val response = censusRepository.getPopulationData()
                _populationData.postValue(response.data)
            } catch (e: Exception) {
                Log.d(TAG, "Exception: ${e.toString()}")
            }
        }
    }
}