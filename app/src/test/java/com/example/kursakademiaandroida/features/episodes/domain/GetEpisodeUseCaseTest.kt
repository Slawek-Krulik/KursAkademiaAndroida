package com.example.kursakademiaandroida.features.episodes.domain

import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.GlobalScope
import org.junit.jupiter.api.Test

internal class GetEpisodeUseCaseTest {

    @Test
    fun `when use case is invoked than execute getEpisodes method from repository`() {
        //given - prepare all elements necessary to run unit test
        val repository =
            mockk<EpisodeRepository>(relaxed = true) //relaxed set true give dummy implementation of method from repository. So we can check if that method was executed
        val useCase = GetEpisodeUseCase(repository)

        //when
        useCase.invoke(
            params = Unit,
            scope = GlobalScope
        )

        //then
        coVerify { repository.getEpisodes() }
    }
}