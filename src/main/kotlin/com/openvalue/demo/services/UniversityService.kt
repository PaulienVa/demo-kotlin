package com.openvalue.demo.services

import com.openvalue.demo.api.AddingUniversityRequest
import com.openvalue.demo.api.University
import com.openvalue.demo.repositories.UniversityRepository
import com.openvalue.demo.repositories.dao.UniversityDao
import com.openvalue.demo.services.exceptions.UniversityNotFoundedInThePast
import org.springframework.stereotype.Service
import kotlin.random.Random

@Service
class UniversityService(
    val universityRepository: UniversityRepository
) {

    fun retrieveUniversities() : List<University>{
        return universityRepository.findAll().map {
            University(it.uniId, it.name, it.city, it.foundationYear, listOf())
        }
    }

    fun addUniversity(request: AddingUniversityRequest):  University {
        val (name, city, foundationYear)  = request
        if (foundationYear < 2021) {
            val universityId = Random.nextInt()

            val universityDao = UniversityDao(null, universityId, name, city, foundationYear)
            universityRepository.save(universityDao)
            return universityRepository.byUniId(universityId).toApi()
        }  else {
            throw UniversityNotFoundedInThePast()
        }
    }
}
