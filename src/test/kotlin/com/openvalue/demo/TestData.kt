package com.openvalue.demo

import com.openvalue.demo.api.University
import com.openvalue.demo.repositories.dao.UniversityDao

val EXPECTED_UNI  = University(123, "SomeTesting Uni", "TestPlanet", 1928, listOf())

private val UNIVERSITIES = listOf(
    University(123, "SomeTesting Uni", "TestPlanet", 1928, listOf())
)

private val UNIVERSITY_DAOS = listOf(
    UniversityDao(null, 123, "SomeTesting Uni", "TestPlanet", 1928)
)

data class TestData(
    val universities: List<University> = UNIVERSITIES,
    val universitiesDaos: List<UniversityDao> = UNIVERSITY_DAOS
)

