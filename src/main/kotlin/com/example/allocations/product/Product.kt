package com.example.allocations.product

import com.fasterxml.jackson.annotation.JsonFormat
import com.example.allocations.team.TeamPerson
import java.time.LocalDate

data class Product(
    val id: Long,
    val name: String,
    val description: String = "",
    val techStack: List<String> = emptyList(),
    @JsonFormat(pattern = "yyyy-MM-dd")
    val startDate: LocalDate,
    val team: List<TeamPerson> = emptyList()
) {
    companion object Translator {
        fun fromNode(node: ProductNode) = Product(
            id = node.id,
            name = node.name,
            description = node.description,
            techStack = node.techStack,
            startDate = node.startDate,
            team = node.team.map { TeamPerson.fromNode(it) }
        )
    }
}
