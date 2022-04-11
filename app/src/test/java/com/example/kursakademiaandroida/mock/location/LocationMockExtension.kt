package com.example.kursakademiaandroida.mock.location

import com.example.kursakademiaandroida.core.api.model.*
import com.example.kursakademiaandroida.features.locations.data.local.model.LocationCached
import com.example.kursakademiaandroida.mock.mock
import org.jetbrains.annotations.TestOnly
import org.junit.jupiter.api.Test

@TestOnly
fun LocationRemote.Companion.mock() = LocationRemote(
    id = 1,
    name = "location name",
    created = "data created",
    dimension = "location dimension",
    residents = emptyList(),
    type = "location type",
    url = "location url"
)

@TestOnly
fun LocationResponse.Companion.mock() = LocationResponse(
    info = ResponseInfo.mock(),
    results = listOf(
        LocationRemote.mock(),
        LocationRemote.mock(),
        LocationRemote.mock()
    )
)

@TestOnly
fun LocationCached.Companion.mock() = LocationCached(
    id = 1,
    name = "location name",
    dimension = "location dimension",
    residents = emptyList(),
    type = "location type",
    url = "location url"
)


