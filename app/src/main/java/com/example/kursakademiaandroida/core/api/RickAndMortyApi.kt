package com.example.kursakademiaandroida.core.api

import com.example.kursakademiaandroida.core.api.model.CharacterResponse
import com.example.kursakademiaandroida.core.api.model.EpisodeResponse
import retrofit2.http.GET

interface RickAndMortyApi {

    @GET("episode")
    suspend fun getEpisodes(): EpisodeResponse

    @GET("character")
    suspend fun getCharacters(): CharacterResponse
}