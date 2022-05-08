package com.example.kursakademiaandroida.features.characters.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.example.kursakademiaandroida.core.base.BaseViewModel
import com.example.kursakademiaandroida.features.characters.domain.GetCharacterUseCase
import com.example.kursakademiaandroida.features.characters.domain.model.Character
import com.example.kursakademiaandroida.features.characters.presentation.model.CharacterDisplayable

class CharacterViewModel(private val getCharacterUseCase: GetCharacterUseCase) : BaseViewModel() {

    private val _characters by lazy {
        MutableLiveData<List<Character>>()
            .also { getCharacters(it) }
    }

    val character: LiveData<List<CharacterDisplayable>> by lazy {
        _characters.map { character ->
            character.map { CharacterDisplayable(it) }
        }
    }

    private fun getCharacters(charactersLiveData: MutableLiveData<List<Character>>) {
        setPendingState()
        getCharacterUseCase(params = Unit, scope = viewModelScope) { result ->
            setIdleState()
            result.onSuccess { charactersLiveData.value = it }
            result.onFailure { handleFailure(it) }

        }

    }

}
