package com.example.kursakademiaandroida.core.api.model

import com.example.kursakademiaandroida.features.characters.domain.model.CharacterOrigin
import com.google.gson.annotations.SerializedName

data class OriginRemote(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
) {
    fun toOrigin() = CharacterOrigin(
        name = name,
        url = url
    )
}