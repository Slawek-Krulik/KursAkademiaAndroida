package com.example.kursakademiaandroida.core.api.model

import com.example.kursakademiaandroida.features.characters.domain.model.CharacterLocation
import com.google.gson.annotations.SerializedName

data class CharacterLocationRemote(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
) {
    fun toCharacterLocation() = CharacterLocation(name = name, url = url)
}