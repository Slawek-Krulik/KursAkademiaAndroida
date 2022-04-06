package com.example.kursakademiaandroida.features.locations.data.local.model

import androidx.room.Entity
import com.example.kursakademiaandroida.features.locations.domain.model.Location

@Entity
data class LocationCached(
    val id: Int,
    val name: String,
    val dimension: String,
    val residents: List<String>,
    val type: String,
    val url: String
) {
    constructor(location: Location) : this(
        location.id,
        location.name,
        location.dimension,
        location.residents,
        location.type,
        location.url
    )

    fun toLocation() = Location(
        id = id,
        name = name,
        dimension = dimension,
        residents = residents,
        type = type,
        url = url
    )
}