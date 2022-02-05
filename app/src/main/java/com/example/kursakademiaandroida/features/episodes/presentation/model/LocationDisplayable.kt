package com.example.kursakademiaandroida.features.episodes.presentation.model

import com.example.kursakademiaandroida.features.episodes.domain.model.Location

data class LocationDisplayable(
    val id: Int,
    val name: String,
    val dimension: String,
    val residents: List<String>,
    val type: String,
    val url: String
) {
    constructor(location: Location) : this(
        id = location.id,
        name = location.name,
        dimension = location.dimension,
        residents = location.residents,
        type = location.type,
        url = location.url
    )
}