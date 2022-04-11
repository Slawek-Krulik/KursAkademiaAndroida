package com.example.kursakademiaandroida.features.characters.data.local.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.kursakademiaandroida.features.characters.domain.model.Character
import com.example.kursakademiaandroida.features.characters.domain.model.CharacterLocation
import com.example.kursakademiaandroida.features.characters.domain.model.CharacterOrigin

@Entity
data class CharacterCached(
    @PrimaryKey
    val id: Int,
    val episode: List<String>,
    val gender: String,
    val image: String,
    @Embedded(prefix = "CharacterLocationCached")
    val location: CharacterLocationCached,
    val name: String,
    @Embedded(prefix = "CharacterOriginCached")
    val origin: CharacterOriginCached,
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
        CharacterLocationCached(character.location),
        character.name,
        CharacterOriginCached(character.origin),
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
        location = location.toCharacterLocation(),
        name = name,
        origin = origin.toCharacterOrigin(),
        species = species,
        status = status,
        type = type,
        url = url
    )

    data class CharacterOriginCached(
        val name: String,
        val url: String
    ) {
        constructor(characterOrigin: CharacterOrigin) : this(
            name = characterOrigin.name,
            url = characterOrigin.url
        )

        companion object

        fun toCharacterOrigin() = CharacterOrigin(
            name = name,
            url = url
        )
    }

    data class CharacterLocationCached(
        val name: String,
        val url: String
    ) {
        constructor(characterLocation: CharacterLocation) : this(
            name = characterLocation.name,
            url = characterLocation.url
        )

        companion object

        fun toCharacterLocation() = CharacterLocation(
            name = name,
            url = url
        )
    }
}