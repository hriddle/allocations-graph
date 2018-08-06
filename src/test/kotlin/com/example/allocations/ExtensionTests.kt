package com.example.allocations

import org.amshove.kluent.shouldEqual
import org.junit.Test

import java.util.Optional

class ExtensionTests {

    @Test
    fun `toNullable converts a Java Optional type to a Kotlin nullable type`() {
        Optional.of("hello").toNullable() shouldEqual "hello"
    }

    @Test
    fun `toNullable converts an empty Java Optional to null`() {
        Optional.ofNullable<String?>(null).toNullable() shouldEqual null
    }
}