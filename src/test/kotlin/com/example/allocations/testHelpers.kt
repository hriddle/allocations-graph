package com.example.allocations

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.example.allocations.person.Person
import com.example.allocations.person.PersonNode
import com.example.allocations.product.Product

private val objectMapper = ObjectMapper().registerKotlinModule().registerModule(JavaTimeModule())

val Person.json: String get() = objectMapper.writeValueAsString(this)
val Product.json: String get() = objectMapper.writeValueAsString(this)

val Person.asInsert get() = this.copy(id = -1)
val Product.asInsert get() = this.copy(id = -1)

val PersonNode.asInsert get() = this.copy(id = -1)