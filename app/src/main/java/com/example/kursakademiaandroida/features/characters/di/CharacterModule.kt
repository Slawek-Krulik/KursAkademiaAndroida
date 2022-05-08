package com.example.kursakademiaandroida.features.characters.di

import com.example.kursakademiaandroida.features.characters.data.repository.CharacterRepositoryImpl
import com.example.kursakademiaandroida.features.characters.domain.CharacterRepository
import com.example.kursakademiaandroida.features.characters.domain.GetCharacterUseCase
import com.example.kursakademiaandroida.features.characters.presentation.CharacterFragment
import com.example.kursakademiaandroida.features.characters.presentation.CharacterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val characterModule = module {
    //data
    factory<CharacterRepository> { CharacterRepositoryImpl(get(), get(), get()) }

    //domain
    factory { GetCharacterUseCase(get()) }

    //presentation
    viewModel { CharacterViewModel(get(), get()) }
    factory { CharacterFragment() }
}