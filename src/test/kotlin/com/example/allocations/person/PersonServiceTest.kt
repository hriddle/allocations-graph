package com.example.allocations.person

import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.util.Optional

class PersonServiceTest {

    private val jakeNode = PersonNode(id = 1, name = "Jake Peralta", role = "DETECTIVE")
    private val amyNode = PersonNode(id = 2, name = "Amy Santiago", role = "DETECTIVE")

    private val holtNodeWithoutId = PersonNode(id = -1, name = "Ray Holt", role = "CAPTAIN")
    private val holtNodeWithId = holtNodeWithoutId.copy(id = 3)
    private val holt = Person.fromNode(holtNodeWithoutId)

    private val mockRepository: PersonRepository = mock {
        on { it.findAll() } doReturn listOf(jakeNode, amyNode)
        on { it.findById(1) } doReturn Optional.of(jakeNode)
        on { it.findById(2) } doReturn Optional.of(amyNode)
        on { it.save(holtNodeWithoutId) } doReturn holtNodeWithId
    }

    private val personService = PersonService(mockRepository)

    @Test
    fun `it calls the repository to find all people`() {
        assertThat(personService.findAllPeople()).containsExactlyInAnyOrder(
            Person.fromNode(jakeNode), Person.fromNode(amyNode)
        )
        verify(mockRepository).findAll()
    }

    @Test
    fun `it calls the repository to find a person by id`() {
        assertThat(personService.findPersonById(1)).isEqualTo(Person.fromNode(jakeNode))
        verify(mockRepository).findById(1)
    }

    @Test
    fun `it calls the repository to save a new person`() {
        assertThat(personService.savePerson(holt)).isEqualTo(Person.fromNode(holtNodeWithId))
        verify(mockRepository).save(holtNodeWithoutId)
    }
}