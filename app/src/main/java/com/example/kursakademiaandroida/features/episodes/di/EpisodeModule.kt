package com.example.kursakademiaandroida.features.episodes.di

import com.example.kursakademiaandroida.features.episodes.data.repository.EpisodeRepositoryImpl
import com.example.kursakademiaandroida.features.episodes.domain.EpisodeRepository
import com.example.kursakademiaandroida.features.episodes.domain.GetEpisodeUseCase
import com.example.kursakademiaandroida.features.episodes.presentation.EpisodeFragment
import com.example.kursakademiaandroida.features.episodes.presentation.EpisodeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val episodeModule = module {
    //data
    factory<EpisodeRepository> { EpisodeRepositoryImpl(get(), get(), get(), get()) }

    //domain
    factory { GetEpisodeUseCase(get()) }

    //presentation
    viewModel { EpisodeViewModel(get(), get()) }
    factory { EpisodeFragment() }
}