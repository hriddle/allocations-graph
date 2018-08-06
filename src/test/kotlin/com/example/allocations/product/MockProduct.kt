package com.example.allocations.product

import java.time.LocalDate

object MockProduct {
    val fullBoyle = Product(id = 1, name = "Full Boyle", description = "", techStack = listOf("Comedy", "Action"), startDate = LocalDate.of(2014, 2, 11))
    val puzzleMaster = Product(id = 2, name = "The Puzzle Master", description = "", techStack = listOf("Comedy", "Action"), startDate = LocalDate.of(2018, 4, 8))
    val terryKitties = Product(id = 3, name = "Terry Kitties", description = "", techStack = listOf("Action"), startDate = LocalDate.of(2016, 3, 15))
    val coralPalms = Product(id = 4, name = "Coral Palms", description = "", techStack = listOf("Comedy"), startDate = LocalDate.of(2016, 9, 20))
}

