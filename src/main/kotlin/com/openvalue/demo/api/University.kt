package com.openvalue.demo.api

data class University(
    val universityId: Int,
    val name: String,
    val city: String,
    val foundationYear: Int,
    val students: List<Student>
)

data class AddingUniversityRequest (
    val name: String,
    val city: String,
    val foundationYear: Int
)

data class Student(
    val studentId: Int,
    val name: String,
    val birthDate: String
)
