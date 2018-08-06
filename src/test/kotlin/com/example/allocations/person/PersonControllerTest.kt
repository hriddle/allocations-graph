package com.example.allocations.person

import com.example.allocations.asInsert
import com.example.allocations.json
import com.example.allocations.person.MockPerson.amy
import com.example.allocations.person.MockPerson.jake
import com.example.allocations.person.MockPerson.holt
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Before
import org.junit.Test
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.header
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders

class PersonControllerTest {

    private lateinit var mockMvc: MockMvc

    private val mockPersonService: PersonService = mock {
        whenever(it.findAllPeople()) doReturn listOf(MockPerson.jake, amy, holt)

        whenever(it.findPersonById(1)) doReturn jake
        whenever(it.findPersonById(2)) doReturn amy
        whenever(it.findPersonById(3)) doReturn holt

        whenever(it.savePerson(holt.asInsert)) doReturn holt
    }

    @Before
    fun setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(PersonController(service = mockPersonService)).build()
    }

    @Test
    fun `GET people returns a 200 and a list of Person`() {
        mockMvc.perform(get("/people"))
            .andExpect(status().isOk)
            .andExpect(content().string("[${jake.json},${amy.json},${holt.json}]"))

        verify(mockPersonService).findAllPeople()
    }

    @Test
    fun `GET people returns a 200 and an empty list`() {
        whenever(mockPersonService.findAllPeople()) doReturn emptyList<Person>()

        mockMvc.perform(get("/people"))
            .andExpect(status().isOk)
            .andExpect(content().string("[]"))

        verify(mockPersonService).findAllPeople()
    }

    @Test
    fun `GET person by id returns a 200 and a Person`() {
        mockMvc.perform(get("/people/${jake.id}"))
            .andExpect(status().isOk)
            .andExpect(content().string(jake.json))

        verify(mockPersonService).findPersonById(jake.id)
    }

    @Test
    fun `GET person by id returns a 404 when Person doesn't exist`() {
        val badId = 123L

        mockMvc.perform(get("/people/$badId"))
            .andExpect(status().isNotFound)
            .andExpect(content().string(""))

        verify(mockPersonService).findPersonById(badId)
    }

    @Test
    fun `POST person returns a 201 and the Person`() {
        mockMvc.perform(post("/people")
            .header("Content-Type", "application/json")
            .content(holt.asInsert.json))
            .andExpect(status().isCreated)
            .andExpect(content().string(holt.json))
            .andExpect(header().string("Location", "/people/${holt.id}"))

        verify(mockPersonService).savePerson(holt.asInsert)
    }
}