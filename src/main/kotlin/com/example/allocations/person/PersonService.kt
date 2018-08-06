package com.example.allocations.person

import com.example.allocations.toNullable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PersonService(val personRepository: PersonRepository) {
    @Transactional(readOnly = true)
    fun findAllPeople(): List<Person> =
        personRepository.findAll().map { Person.fromNode(it) }

    @Transactional(readOnly = true)
    fun findPersonById(id: Long): Person? =
        personRepository.findById(id).toNullable()?.let { Person.fromNode(it) }

    @Transactional
    fun savePerson(person: Person): Person {
        return personRepository.save(
            PersonNode(name = person.name, role = person.role, level = person.level)
        ).let { Person.fromNode(it) }
    }
}