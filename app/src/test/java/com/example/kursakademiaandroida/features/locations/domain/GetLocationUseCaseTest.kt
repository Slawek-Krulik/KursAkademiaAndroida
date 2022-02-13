package com.example.kursakademiaandroida.features.locations.domain

import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.GlobalScope
import org.junit.jupiter.api.Test

internal class GetLocationUseCaseTest {

    @Test
    fun `when use case is invoked than execute getLocations method from repository`() {
        //given - prepare all elements necessary to run unit test
        val repository =
            mockk<LocationRepository>(relaxed = true) //relaxed set true give dummy implementation of method from repository. So we can check if that method was executed
        val useCase = GetLocationUseCase(repository)

        //when
        useCase.invoke(
            params = Unit,
            scope = GlobalScope
        )

        //then
        coVerify { repository.getLocations() }
    }
}