package com.example.kursakademiaandroida.core.api.model

import com.example.kursakademiaandroida.features.locations.domain.model.Location
import com.google.gson.annotations.SerializedName


data class LocationRemote(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("created") val created: String,
    @SerializedName("dimension") val dimension: String,
    @SerializedName("residents") val residents: List<String>,
    @SerializedName("type") val type: String,
    @SerializedName("url") val url: String
) {
    companion object

    fun toLocation() = Location(
        id = id,
        name = name,
        dimension = dimension,
        residents = residents,
        type = type,
        url = url
    )
}