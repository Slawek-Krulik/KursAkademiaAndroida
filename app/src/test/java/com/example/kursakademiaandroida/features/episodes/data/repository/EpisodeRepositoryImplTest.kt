package com.example.kursakademiaandroida.features.episodes.data.repository

import com.example.kursakademiaandroida.core.api.RickAndMortyApi
import com.example.kursakademiaandroida.core.api.model.EpisodeResponse
import com.example.kursakademiaandroida.core.network.NetworkStateProvider
import com.example.kursakademiaandroida.features.episodes.data.local.EpisodeDao
import com.example.kursakademiaandroida.features.episodes.data.local.model.EpisodeCached
import com.example.kursakademiaandroida.mock.mock
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

internal class EpisodeRepositoryImplTest {
    @Test
    fun `GIVEN network is connected WHEN episodes request THEN fetch episodes from API`() {
        //given
        val api = mockk<RickAndMortyApi> {
            coEvery { getEpisodes() } returns EpisodeResponse.mock()
        }
        val episodeDao = mockk<EpisodeDao>(relaxed = true)
        val networkProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns true
        }

        val repository = EpisodeRepositoryImpl(api, episodeDao, networkProvider)

        //when
        runBlocking { repository.getEpisodes() }

        //then
        coVerify { api.getEpisodes() }
    }

    @Test
    fun `GIVEN network is connected AND successful data fetch THEN save episodes to database`() {
        //given
        val api = mockk<RickAndMortyApi> {
            coEvery { getEpisodes() } returns EpisodeResponse.mock()
        }
        val episodeDao = mockk<EpisodeDao>(relaxed = true)
        val networkProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns true
        }

        val repository = EpisodeRepositoryImpl(api, episodeDao, networkProvider)

        //when
        runBlocking { repository.getEpisodes() }

        //then
        coVerify { episodeDao.saveEpisodes(*anyVararg()) }
    }

    @Test
    fun `GIVEN network is disconnected WHEN episodes request THEN fetch episodes from local database`() {
        //given
        val api = mockk<RickAndMortyApi>(relaxed = true)
        val episodeDao = mockk<EpisodeDao> {
            coEvery { getEpisodes() } returns listOf(
                EpisodeCached.mock(),
                EpisodeCached.mock(),
                EpisodeCached.mock()
            )
        }
        val networkProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns false
        }

        val repository = EpisodeRepositoryImpl(api, episodeDao, networkProvider)

        //when
        runBlocking { repository.getEpisodes() }

        //then
        coVerify { episodeDao.getEpisodes() }
    }
}