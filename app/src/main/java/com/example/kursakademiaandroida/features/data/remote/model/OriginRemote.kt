package com.example.kursakademiaandroida.features.data.remote.model

import com.example.kursakademiaandroida.features.characters.domain.model.Origin
import com.google.gson.annotations.SerializedName

data class OriginRemote(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
) {
    fun toOrigin() = Origin(
        name = name,
        url = url
    )
}