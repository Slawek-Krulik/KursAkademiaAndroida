package com.example.kursakademiaandroida.features.characters.presentation.model

import com.example.kursakademiaandroida.features.characters.domain.model.CharacterOrigin

data class OriginDisplayable(
    val name: String,
    val url: String
) {
    constructor(origin: CharacterOrigin) : this(
        name = origin.name,
        url = origin.url
    )
}
