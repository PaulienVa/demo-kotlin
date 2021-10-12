package com.openvalue.demo.controllers

import com.openvalue.demo.api.AddingUniversityRequest
import com.openvalue.demo.api.University
import com.openvalue.demo.services.UniversityService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
open class UniversityController(
    private val universityService: UniversityService
    ) {

    @GetMapping("/universities")
    fun retrieveUniversities() : ResponseEntity<List<University>> {
        val universities = universityService.retrieveUniversities()
        return ResponseEntity.ok(universities)
    }

    @PutMapping("/universities")
    fun save(@RequestBody request: AddingUniversityRequest): ResponseEntity<University> {
        val university = universityService.addUniversity(request)
        return  ResponseEntity.ok(university)
    }
}
