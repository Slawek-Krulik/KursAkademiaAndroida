package com.example.kursakademiaandroida.core.api.model

import com.google.gson.annotations.SerializedName

class EpisodeResponse(
    @SerializedName("info") val info: ResponseInfo,
    @SerializedName("results") val results: List<EpisodeRemote>
) {
}