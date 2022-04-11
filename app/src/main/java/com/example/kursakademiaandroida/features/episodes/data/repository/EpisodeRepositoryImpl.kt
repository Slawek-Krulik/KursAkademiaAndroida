package com.example.kursakademiaandroida.features.episodes.data.repository

import com.example.kursakademiaandroida.core.api.RickAndMortyApi
import com.example.kursakademiaandroida.core.network.NetworkStateProvider
import com.example.kursakademiaandroida.features.episodes.data.local.EpisodeDao
import com.example.kursakademiaandroida.features.episodes.data.local.model.EpisodeCached
import com.example.kursakademiaandroida.features.episodes.domain.EpisodeRepository
import com.example.kursakademiaandroida.features.episodes.domain.model.Episode

class EpisodeRepositoryImpl(
    private val rickAndMortyApi: RickAndMortyApi,
    private val episodeDao: EpisodeDao,
    private val networkStateProvider: NetworkStateProvider
) : EpisodeRepository {

    override suspend fun getEpisodes(): List<Episode> {
        return if (networkStateProvider.isNetworkAvailable()) {
            getEpisodeFromRemote()
                .also { saveEpisodesToLocal(it) }
        } else {
            getEpisodeFromLocal()
        }
    }

    private suspend fun getEpisodeFromRemote(): List<Episode> {
        return rickAndMortyApi.getEpisodes()
            .results
            .map { it.toEpisode() }
    }

    private suspend fun saveEpisodesToLocal(episodes: List<Episode>) {
        episodes.map { EpisodeCached(it) }
            .toTypedArray()
            .let { episodeDao.saveEpisodes(*it) }
    }

    private suspend fun getEpisodeFromLocal(): List<Episode> {
        return episodeDao.getEpisodes().map { it.toEpisode() }
    }
}