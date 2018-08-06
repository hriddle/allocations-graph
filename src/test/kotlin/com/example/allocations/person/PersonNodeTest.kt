package com.example.allocations.person

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.example.allocations.team.WorkedOn
import org.amshove.kluent.shouldBe
import org.amshove.kluent.shouldEqual
import org.amshove.kluent.shouldNotContain
import org.junit.Test

class PersonNodeTest {

    @Test
    fun `converting PersonNode to JSON should ignore 'person' key when building 'workedOn' key`() {
        val node = PersonNode(workedOn = arrayListOf(WorkedOn()))
        val json = jacksonObjectMapper().writeValueAsString(node)

        json shouldNotContain "\"person\":"
    }

    @Test
    fun `hashCode should not consider the 'workedOn' field`() {

        PersonNode().hashCode() shouldEqual PersonNode(workedOn = arrayListOf(WorkedOn())).hashCode()
    }

    @Test
    fun `equals should not consider the 'workedOn' field`() {
        val one = PersonNode()
        val two = PersonNode(workedOn = arrayListOf(WorkedOn()))

        (one == two) shouldBe true
    }

    @Test
    fun `toString should not consider the 'workedOn' field`() {

        PersonNode().toString() shouldNotContain "workedOn=["
    }
}