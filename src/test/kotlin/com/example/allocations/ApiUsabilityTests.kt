package com.example.allocations

import com.example.allocations.person.MockPerson
import com.example.allocations.person.PersonService
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.header
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@RunWith(SpringRunner::class)
@SpringBootTest
@AutoConfigureMockMvc
class ApiUsabilityTests {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var personService: PersonService

    @Before
    fun setUp() {

        whenever(personService.findAllPeople()) doReturn listOf(MockPerson.jake, MockPerson.amy, MockPerson.holt)

        whenever(personService.findPersonById(1)) doReturn MockPerson.jake
        whenever(personService.findPersonById(2)) doReturn MockPerson.amy
        whenever(personService.findPersonById(3)) doReturn MockPerson.holt
        whenever(personService.findPersonById(4)) doReturn MockPerson.rosa

        whenever(personService.savePerson(MockPerson.rosa)) doReturn MockPerson.rosa
    }

    @Test
    fun `GET people should allow CORS requests`() {
        val origin = "http://www.someurl.com"
        mockMvc.perform(get("/people").header("Access-Control-Request-Method", "GET").header("Origin", origin))
            .andExpect(status().isOk)
            .andExpect(header().string("Access-Control-Allow-Origin", origin))
    }

    @Test
    fun `GET products should allow CORS requests`() {
        val origin = "http://www.someurl.com"
        mockMvc.perform(get("/products").header("Access-Control-Request-Method", "GET").header("Origin", origin))
            .andExpect(status().isOk)
            .andExpect(header().string("Access-Control-Allow-Origin", origin))
    }
}