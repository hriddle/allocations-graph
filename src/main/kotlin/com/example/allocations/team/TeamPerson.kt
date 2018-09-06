package com.example.allocations.team

import java.time.LocalDate

data class TeamPerson(
    val id: Long,
    val name: String,
    val company: String,
    val role: String,
    val startDate: LocalDate,
    val endDate: LocalDate? = null
) {
    companion object Translator {
        fun fromNode(node: WorkedOn) = TeamPerson(
            id = node.person.id,
            name = node.person.name,
            company = node.company,
            role = node.role,
            startDate = node.startDate,
            endDate = node.endDate
        )
    }
}