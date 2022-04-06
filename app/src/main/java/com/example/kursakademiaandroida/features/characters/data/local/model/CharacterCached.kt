package com.example.kursakademiaandroida.features.characters.data.local.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.kursakademiaandroida.features.characters.domain.model.Character
import com.example.kursakademiaandroida.features.characters.domain.model.CharacterLocation
import com.example.kursakademiaandroida.features.characters.domain.model.Origin

@Entity
data class CharacterCached(
    @PrimaryKey
    val id: Int,
    val episode: List<String>,
    val gender: String,
    val image: String,
    @Embedded(prefix = "CharacterLocationCached") val location: CharacterLocation,
    val name: String,
    @Embedded(prefix = "CharacterOriginCached") val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
) {
    constructor(character: Character) : this(
        character.id,
        character.episode,
        character.gender,
        character.image,
        character.location,
        character.name,
        character.origin,
        character.species,
        character.status,
        character.type,
        character.url
    )

    companion object

    fun toCharacter() = Character(
        id = id,
        episode = episode,
        gender = gender,
        image = image,
        location = location,
        name = name,
        origin = origin,
        species = species,
        status = status,
        type = type,
        url = url
    )
}