package com.example.kursakademiaandroida.features.locations.domain.model

data class Location(
    val id: Int,
    val name: String,
    val dimension: String,
    val residents: List<String>,
    val type: String,
    val url: String
)