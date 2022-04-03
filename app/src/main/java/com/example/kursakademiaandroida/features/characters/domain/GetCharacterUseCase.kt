package com.example.kursakademiaandroida.features.characters.domain

import com.example.kursakademiaandroida.core.base.UseCase
import com.example.kursakademiaandroida.features.characters.domain.model.Character

class GetCharacterUseCase(private val repository: CharacterRepository) :
    UseCase<List<Character>, Unit>() {

    override suspend fun action(params: Unit) = repository.getCharacters()
}