package com.openvalue.demo.repositories.dao

import com.openvalue.demo.api.University

data class UniversityDao(
    val id: Int?,
    val uniId: Int,
    val name: String,
    val city: String,
    val foundationYear: Int
) {
    fun toApi() : University = University(uniId, name, city, foundationYear, listOf())
}
