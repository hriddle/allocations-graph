package com.example.allocations.product

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.example.allocations.team.WorkedOn
import org.amshove.kluent.shouldBe
import org.amshove.kluent.shouldEqual
import org.amshove.kluent.shouldNotContain
import org.junit.Test

class ProductNodeTest {

    @Test
    fun `converting ProductNode to JSON should ignore 'product' key when building 'team' key`() {
        val node = ProductNode(team = arrayListOf(WorkedOn()))
        val json = jacksonObjectMapper().writeValueAsString(node)

        json shouldNotContain "\"product\":"
    }

    @Test
    fun `hashCode should not consider the 'team' field`() {

        ProductNode().hashCode() shouldEqual ProductNode(team = arrayListOf(WorkedOn())).hashCode()
    }

    @Test
    fun `equals should not consider the 'team' field`() {
        val one = ProductNode()
        val two = ProductNode(team = arrayListOf(WorkedOn()))

        (one == two) shouldBe true
    }

    @Test
    fun `toString should not consider the 'team' field`() {

        ProductNode().toString() shouldNotContain "team=["
    }
}