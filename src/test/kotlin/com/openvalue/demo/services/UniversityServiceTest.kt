package com.openvalue.demo.services

import com.openvalue.demo.EXPECTED_UNI
import com.openvalue.demo.TestData
import com.openvalue.demo.api.University
import com.openvalue.demo.repositories.UniversityRepository
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

fun <R> given(block: (TestData) -> R): R {
    return block(TestData())
}

inline fun <T,  R> T.`when`(block: T.() -> List<R>) : ListResult<R> {
    return ListResult(block(this))
}

inline fun <T, R> T.then(block: T.() -> R) : R {
    return block(this)
}

data class ListResult<T>(val list: List<T>) {
    infix fun hasSize(size: Int) {
        assertTrue(list.size ==  1)
    }

    infix fun contains(expected: T) {
        assertTrue(list.contains(expected))
    }
}
