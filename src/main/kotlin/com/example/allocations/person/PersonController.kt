package com.example.allocations.person

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

private const val people = "/people"

@RestController
@RequestMapping(people)
class PersonController(val service: PersonService) {

    @GetMapping("")
    fun getPeople(): ResponseEntity<List<Person>> =
        service.findAllPeople().let { ResponseEntity.ok(it) }

    @GetMapping("/{id}")
    fun getPerson(@PathVariable id: Long): ResponseEntity<Person> =
        service.findPersonById(id)
            ?.let { ResponseEntity.ok(it) }
            ?: ResponseEntity.notFound().build()

    @PostMapping("")
    fun createPerson(@RequestBody person: Person): ResponseEntity<Any> =
        service.savePerson(person).let {
            ResponseEntity.created(URI("$people/${it.id}")).body(it)
        }
}
