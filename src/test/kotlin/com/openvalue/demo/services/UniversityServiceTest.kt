package com.openvalue.demo.services

import com.openvalue.demo.EXPECTED_UNI
import com.openvalue.demo.TestData
import com.openvalue.demo.api.University
import com.openvalue.demo.repositories.UniversityRepository
import com.openvalue.demo.utils.EXPECTED_UNI
import com.openvalue.demo.utils.`when`
import com.openvalue.demo.utils.given
import com.openvalue.demo.utils.then
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import kotlin.reflect.KClass

class UniversityServiceTest {

    private val universityRepository = mockk<UniversityRepository>()
    val universityService = UniversityService(universityRepository)

    @Test
    fun `when universities are retrieved they are returned by the service as an api object`() {
        given {
            every {
                universityRepository.findAll()
            } returns it.universitiesDaos
        }.`when` {
            universityService.retrieveUniversities()
        }.then {
            this hasSize 1
            this contains EXPECTED_UNI
        }

    }
}
