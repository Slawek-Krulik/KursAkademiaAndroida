package com.example.kursakademiaandroida.features.characters.presentation

import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import com.example.kursakademiaandroida.core.base.UiState
import com.example.kursakademiaandroida.features.characters.domain.GetCharacterUseCase
import com.example.kursakademiaandroida.features.characters.domain.model.Character
import com.example.kursakademiaandroida.mock.character.mock
import com.example.kursakademiaandroida.utils.ViewModelTest
import com.example.kursakademiaandroida.utils.getOrAwaitValue
import com.example.kursakademiaandroida.utils.observeForTesting
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.amshove.kluent.shouldBe
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class CharacterViewModelTest : ViewModelTest() {

    @Test
    fun `WHEN character live data is observed THEN set pending state`() {
        //given
        val useCase = mockk<GetCharacterUseCase>(relaxed = true)
        val viewModel = CharacterViewModel(useCase)

        //when
        viewModel.character.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Pending
    }

    @Test
    fun `WHEN character live data is observed THEN invoke use case to get characters`() {
        //given
        val useCase = mockk<GetCharacterUseCase>(relaxed = true)
        val viewModel = CharacterViewModel(useCase)

        //when
        viewModel.character.observeForTesting()

        //then
        verify { useCase(Unit, viewModel.viewModelScope, any(), any()) }
    }

    @Test
    fun `GIVEN use case result is success WHEN character live data is observed THEN set idle state AND set result in live data`() {
        //given
        val characters =
            listOf(Character.mock(), Character.mock(), Character.mock(), Character.mock())
        val useCase = mockk<GetCharacterUseCase> {
            every { this@mockk(Unit, any(), any(), any()) } answers {
                lastArg<(Result<List<Character>>) -> Unit>()(Result.success(characters))
            }
        }
        val viewModel = CharacterViewModel(useCase)

        //when
        viewModel.character.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Idle
        viewModel.character.getOrAwaitValue().forEachIndexed { index, characterDisplayable ->
            val character = characters[index]
            characterDisplayable.id shouldBe character.id
            characterDisplayable.origin shouldBe character.origin
            characterDisplayable.name shouldBe character.name
            characterDisplayable.url shouldBe character.url
        }
    }

    @Test
    fun `GIVEN use case result is failure WHEN character live data is observed THEN set idle state AND show error message`() {
        //given
        val throwable = Throwable("Failure..")
        val useCase = mockk<GetCharacterUseCase> {
            every { this@mockk(Unit, any(), any(), any()) } answers {
                lastArg<(Result<List<Character>>) -> Unit>()(Result.failure(throwable))
            }
        }
        val observer = mockk<Observer<String>>(relaxed = true)
        val viewModel = CharacterViewModel(useCase)

        //when
        viewModel.message.observeForever(observer)
        viewModel.character.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Idle
        verify { observer.onChanged(throwable.message) }
    }
}