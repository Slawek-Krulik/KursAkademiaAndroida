package com.example.kursakademiaandroida.features.episodes.domain.model

data class Episode(
    val id: Int,
    val name: String,
    val airDate: String,
    val characters: List<String>,
    val code: String,
    val url: String
) {
    companion object
}