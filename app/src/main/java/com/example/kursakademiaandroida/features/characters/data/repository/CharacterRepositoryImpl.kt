package com.example.kursakademiaandroida.features.characters.data.repository

import com.example.kursakademiaandroida.core.api.RickAndMortyApi
import com.example.kursakademiaandroida.core.exception.ErrorWrapper
import com.example.kursakademiaandroida.core.exception.callOrThrow
import com.example.kursakademiaandroida.core.network.NetworkStateProvider
import com.example.kursakademiaandroida.features.characters.data.local.CharacterDao
import com.example.kursakademiaandroida.features.characters.data.local.model.CharacterCached
import com.example.kursakademiaandroida.features.characters.domain.CharacterRepository
import com.example.kursakademiaandroida.features.characters.domain.model.Character

class CharacterRepositoryImpl(
    private val rickAndMortyApi: RickAndMortyApi,
    private val characterDao: CharacterDao,
    private val networkStateProvider: NetworkStateProvider,
    private val errorWrapper: ErrorWrapper
) : CharacterRepository {
    override suspend fun getCharacters(): List<Character> {
        return if (networkStateProvider.isNetworkAvailable()) {
            callOrThrow(errorWrapper) { getCharacterFromRemote() }
                .also { saveCharacterToLocal(it) }
        } else {
            getCharacterFromLocal()
        }
    }

    private suspend fun getCharacterFromRemote(): List<Character> {
        return rickAndMortyApi.getCharacters()
            .results
            .map { it.toCharacter() }
    }

    private suspend fun saveCharacterToLocal(characters: List<Character>) {
        characters.map { CharacterCached(it) }
            .toTypedArray()
            .let { characterDao.saveCharacters(*it) }
    }

    private suspend fun getCharacterFromLocal(): List<Character> {
        return characterDao.getCharacters().map { it.toCharacter() }
    }
}