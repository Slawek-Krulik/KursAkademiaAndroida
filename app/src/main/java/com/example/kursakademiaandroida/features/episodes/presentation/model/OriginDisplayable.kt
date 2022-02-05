package com.example.kursakademiaandroida.features.episodes.presentation.model

import com.example.kursakademiaandroida.features.episodes.domain.model.Origin

data class OriginDisplayable(
    val name: String,
    val url: String
) {
    constructor(origin: Origin) : this(
        name = origin.name,
        url = origin.url
    )
}
