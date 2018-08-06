package com.example.allocations.person

import com.example.allocations.team.WorkedOn
import java.time.LocalDate

data class Person(
    val id: Long,
    val name: String,
    val role: String,
    val level: String,
    val productHistory: List<ProductHistory> = emptyList()
) {
    companion object Translator {
        fun fromNode(node: PersonNode) = Person(
            id = node.id,
            name = node.name,
            role = node.role,
            level = node.level,
            productHistory = node.workedOn.map { ProductHistory.fromNode(it) }
        )
    }
}

data class ProductHistory(
    val id: Long,
    val name: String,
    val startDate: LocalDate,
    val endDate: LocalDate? = null
) {
    companion object Translator {
        fun fromNode(node: WorkedOn): ProductHistory = ProductHistory(
            id = node.product.id,
            name = node.product.name,
            startDate = node.startDate,
            endDate = node.endDate
        )
    }
}
