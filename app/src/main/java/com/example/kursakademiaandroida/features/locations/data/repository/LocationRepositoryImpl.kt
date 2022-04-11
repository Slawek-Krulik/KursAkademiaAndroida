package com.example.kursakademiaandroida.features.locations.data.repository

import com.example.kursakademiaandroida.core.api.RickAndMortyApi
import com.example.kursakademiaandroida.core.network.NetworkStateProvider
import com.example.kursakademiaandroida.features.locations.data.local.LocationDao
import com.example.kursakademiaandroida.features.locations.data.local.model.LocationCached
import com.example.kursakademiaandroida.features.locations.domain.LocationRepository
import com.example.kursakademiaandroida.features.locations.domain.model.Location

class LocationRepositoryImpl(
    private val rickAndMortyApi: RickAndMortyApi,
    private val locationDao: LocationDao,
    private val networkStateProvider: NetworkStateProvider
) : LocationRepository {
    override suspend fun getLocations(): List<Location> {
        return if (networkStateProvider.isNetworkAvailable()) {
            getLocationFromRemote()
                .also { saveLocationsToLocal(it) }
        } else {
            getLocationFromLocal()
        }
    }

    private suspend fun getLocationFromRemote(): List<Location> {
        return rickAndMortyApi.getLocations()
            .results
            .map { it.toLocation() }
    }

    private suspend fun saveLocationsToLocal(locations: List<Location>) {
        locations.map { LocationCached(it) }
            .toTypedArray()
            .let { locationDao.saveLocations(*it) }
    }

    private suspend fun getLocationFromLocal(): List<Location> {
        return locationDao.getLocations().map { it.toLocation() }
    }
}