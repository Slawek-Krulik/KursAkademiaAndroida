package com.example.kursakademiaandroida.features.locations.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.example.kursakademiaandroida.core.base.BaseViewModel
import com.example.kursakademiaandroida.core.exception.ErrorMapper
import com.example.kursakademiaandroida.features.locations.domain.GetLocationUseCase
import com.example.kursakademiaandroida.features.locations.domain.model.Location
import com.example.kursakademiaandroida.features.locations.presentation.model.LocationDisplayable

class LocationViewModel(
    private val getLocationUseCase: GetLocationUseCase,
    private val errorMapper: ErrorMapper
) : BaseViewModel(errorMapper) {

    private val _locations by lazy {
        MutableLiveData<List<Location>>()
            .also { getLocation(it) }
    }

    val locations: LiveData<List<LocationDisplayable>> by lazy {
        _locations.map { locations ->
            locations.map { LocationDisplayable(it) }
        }
    }

    private fun getLocation(locationLiveData: MutableLiveData<List<Location>>) {
        setPendingState()
        getLocationUseCase(params = Unit, scope = viewModelScope) { result ->
            setIdleState()
            result.onSuccess { locationLiveData.value = it }
            result.onFailure { handleFailure(it) }
        }

    }
}
