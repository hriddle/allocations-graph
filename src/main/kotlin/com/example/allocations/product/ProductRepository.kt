package com.example.allocations.product

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.example.allocations.team.WorkedOn
import org.neo4j.ogm.annotation.GeneratedValue
import org.neo4j.ogm.annotation.Id
import org.neo4j.ogm.annotation.NodeEntity
import org.neo4j.ogm.annotation.Relationship
import org.springframework.data.neo4j.repository.Neo4jRepository
import org.springframework.stereotype.Repository
import java.time.LocalDate
import java.util.ArrayList
import java.util.Objects

@Repository
interface ProductRepository : Neo4jRepository<ProductNode, Long>

@NodeEntity(label = "Product")
data class ProductNode(
    @Id @GeneratedValue var id: Long = -1,
    var name: String = "",
    var description: String = "",
    var techStack: List<String> = emptyList(),
    var startDate: LocalDate = LocalDate.now(),
    @JsonIgnoreProperties("product")
    @Relationship(type = "WORKED_ON", direction = Relationship.INCOMING)
    var team: ArrayList<WorkedOn> = ArrayList()
) {
    override fun toString(): String {
        return "ProductNode(id=$id, name='$name', description='$description', techStack=$techStack, startDate=$startDate)"
    }

    override fun equals(other: Any?): Boolean {
        return ((this === other || other is ProductNode)
            && name == other.name
            && description == other.description
            && techStack == other.techStack
            && startDate == other.startDate
            )
    }

    override fun hashCode(): Int {
        return Objects.hash(name, description, techStack, startDate)
    }
}
