package com.example.kursakademiaandroida.features.episodes.presentation.model

import com.example.kursakademiaandroida.features.episodes.domain.model.Character

data class CharacterDisplayable(
    val id: Int,
    val episode: List<String>,
    val gender: String,
    val image: String,
    val location: LocationDisplayable,
    val name: String,
    val origin: OriginDisplayable,
    val species: String,
    val status: String,
    val type: String,
    val url: String
) {
    constructor(character: Character) : this(
        id = character.id,
        episode = character.episode,
        gender = character.gender,
        image = character.image,
        location = LocationDisplayable(location = character.location),
        name = character.name,
        origin = OriginDisplayable(origin = character.origin),
        species = character.species,
        status = character.status,
        type = character.type,
        url = character.url
    )
}