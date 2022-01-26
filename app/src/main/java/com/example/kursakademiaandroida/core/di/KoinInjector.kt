package com.example.kursakademiaandroida.core.di

import org.koin.core.module.Module

val koinInjector: List<Module> = listOf(
    networkModule,
    appModule,
    databaseModule
)