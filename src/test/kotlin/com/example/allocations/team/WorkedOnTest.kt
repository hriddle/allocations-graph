package com.example.allocations.team

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.example.allocations.person.PersonNode
import com.example.allocations.product.ProductNode
import org.amshove.kluent.shouldBe
import org.amshove.kluent.shouldEqual
import org.amshove.kluent.shouldNotContain
import org.junit.Test

class WorkedOnTest {

    @Test
    fun `converting WorkedOn to JSON should ignore 'workedOn' key when building 'person' key`() {
        val node = WorkedOn(person = PersonNode(workedOn = arrayListOf(WorkedOn())))
        val json = jacksonObjectMapper().writeValueAsString(node)

        json shouldNotContain "\"workedOn\":"
    }

    @Test
    fun `converting WorkedOn to JSON should ignore 'team' key when building 'product' key`() {
        val node = WorkedOn(product = ProductNode(team = arrayListOf(WorkedOn())))
        val json = jacksonObjectMapper().writeValueAsString(node)

        json shouldNotContain "\"team\":"
    }

    @Test
    fun `hashCode should only consider the name field within PersonNode and ProductNode`() {
        val one = WorkedOn(person = PersonNode(name = "A"), product = ProductNode(name = "B"))
        val two = WorkedOn(person = PersonNode(name = "A", role = "BLAH"), product = ProductNode(name = "B", description = "BLAH"))

        one.hashCode() shouldEqual two.hashCode()
    }

    @Test
    fun `equals should only consider the name field within PersonNode and ProductNode`() {
        val one = WorkedOn(person = PersonNode(name = "A"), product = ProductNode(name = "B"))
        val two = WorkedOn(person = PersonNode(name = "A", role = "BLAH"), product = ProductNode(name = "B", description = "BLAH"))

        (one == two) shouldBe true
    }

    @Test
    fun `toString should only consider the name field within PersonNode and ProductNode`() {

        WorkedOn().toString() shouldNotContain "PersonNode"
        WorkedOn().toString() shouldNotContain "ProductNode"
    }
}