package com.example.kursakademiaandroida.mock.character

import com.example.kursakademiaandroida.core.api.model.*
import com.example.kursakademiaandroida.features.characters.data.local.model.CharacterCached
import com.example.kursakademiaandroida.features.characters.domain.model.Character
import com.example.kursakademiaandroida.features.characters.domain.model.CharacterLocation
import com.example.kursakademiaandroida.features.characters.domain.model.CharacterOrigin
import com.example.kursakademiaandroida.mock.mock
import org.jetbrains.annotations.TestOnly

@TestOnly
fun CharacterRemote.Companion.mock() =
    CharacterRemote(
        created = "created",
        episode = emptyList(),
        gender = "character gender",
        id = 1,
        image = "character image",
        location = CharacterLocationRemote("name", url = "url"),
        name = "name",
        origin = OriginRemote("name", "url"),
        species = "species",
        status = "status",
        type = "type",
        url = "url"
    )

@TestOnly
fun CharacterResponse.Companion.mock() = CharacterResponse(
    info = ResponseInfo.mock(),
    results = listOf(CharacterRemote.mock(), CharacterRemote.mock(), CharacterRemote.mock())
)

@TestOnly
fun CharacterCached.Companion.mock() = CharacterCached(
    episode = emptyList(),
    gender = "character gender",
    id = 1,
    image = "character image",
    location = CharacterCached.CharacterLocationCached(CharacterLocation("name", "ur")),
    name = "name",
    origin = CharacterCached.CharacterOriginCached(CharacterOrigin("name ", "url")),
    species = "species",
    status = "status",
    type = "type",
    url = "url"
)

@TestOnly
fun CharacterLocation.Companion.mock() =
    CharacterLocation(name = "character location name", url = "character location url")

@TestOnly
fun CharacterOrigin.Companion.mock() =
    CharacterOrigin(name = "character origin name", url = "character origin url")

@TestOnly
fun Character.Companion.mock() = Character(
    episode = emptyList(),
    gender = "character gender",
    id = 1,
    image = "character image",
    location = CharacterLocation.Companion.mock(),
    name = "name",
    origin = CharacterOrigin.Companion.mock(),
    species = "species",
    status = "status",
    type = "type",
    url = "url"
)