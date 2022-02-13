package com.example.kursakademiaandroida.features.characters.domain

import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.GlobalScope
import org.junit.jupiter.api.Test

internal class GetCharacterUseCaseTest {

    @Test
    fun `when use case is invoked than execute getCharacters method from repository`() {
        //given - prepare all elements necessary to run unit test
        val repository =
            mockk<CharacterRepository>(relaxed = true) //relaxed set true give dummy implementation of method from repository. So we can check if that method was executed
        val useCase = GetCharacterUseCase(repository)

        //when
        useCase.invoke(
            params = Unit,
            scope = GlobalScope
        )

        //then
        coVerify { repository.getCharacters() }
    }

}