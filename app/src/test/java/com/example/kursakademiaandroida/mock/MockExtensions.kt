package com.example.kursakademiaandroida.mock

import com.example.kursakademiaandroida.core.api.model.EpisodeRemote
import com.example.kursakademiaandroida.core.api.model.EpisodeResponse
import com.example.kursakademiaandroida.core.api.model.ResponseInfo
import com.example.kursakademiaandroida.features.episodes.data.local.model.EpisodeCached
import com.example.kursakademiaandroida.features.episodes.domain.model.Episode
import org.jetbrains.annotations.TestOnly

@TestOnly
fun ResponseInfo.Companion.mock() = ResponseInfo(
    count = 10,
    pages = 3,
    next = "next page url",
    prev = "previous page url"
)

@TestOnly
fun EpisodeRemote.Companion.mock() = EpisodeRemote(
    id = 1,
    name = "episode name",
    airDate = "episode air",
    characters = emptyList(),
    created = "example date",
    code = "episode code",
    url = "episode url"
)

@TestOnly
fun EpisodeResponse.Companion.mock() =
    EpisodeResponse(
        info = ResponseInfo.mock(),
        results = listOf(
            EpisodeRemote.mock(),
            EpisodeRemote.mock(),
            EpisodeRemote.mock()
        )
    )

@TestOnly
fun EpisodeCached.Companion.mock() = EpisodeCached(
    id = 1,
    name = "episode name",
    airDate = "episode air",
    characters = emptyList(),
    code = "episode code",
    url = "episode url"
)

@TestOnly
fun Episode.Companion.mock() = Episode(
    id = 1,
    name = "episode name",
    airDate = "airDate",
    characters = emptyList(),
    code = "code",
    url = "url"
)