package com.example.kursakademiaandroida.core.di

import com.example.kursakademiaandroida.features.characters.di.characterModule
import com.example.kursakademiaandroida.features.episodes.di.episodeModule
import com.example.kursakademiaandroida.features.locations.di.locationModule
import org.koin.core.module.Module

val featureModules = listOf<Module>(
    episodeModule,
    characterModule,
    locationModule
)