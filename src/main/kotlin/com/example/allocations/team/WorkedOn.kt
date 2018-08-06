package com.example.allocations.team

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.example.allocations.UNKNOWN
import com.example.allocations.person.PersonNode
import com.example.allocations.product.ProductNode
import org.neo4j.ogm.annotation.EndNode
import org.neo4j.ogm.annotation.GeneratedValue
import org.neo4j.ogm.annotation.Id
import org.neo4j.ogm.annotation.Property
import org.neo4j.ogm.annotation.RelationshipEntity
import org.neo4j.ogm.annotation.StartNode
import java.time.LocalDate
import java.util.Objects

@RelationshipEntity(type = "WORKED_ON")
data class WorkedOn(
    @Id @GeneratedValue var id: Long = -1,
    @JsonIgnoreProperties("workedOn")
    @StartNode var person: PersonNode = PersonNode(),
    @JsonIgnoreProperties("team")
    @EndNode var product: ProductNode = ProductNode(),
    @Property var startDate: LocalDate = LocalDate.now(),
    @Property var durationInWeeks: Int = -1,
    @Property var role: String = UNKNOWN
) {
    val endDate: LocalDate
        get() =
            if (durationInWeeks > 0) startDate.plusWeeks(durationInWeeks.toLong())
            else LocalDate.MAX

    override fun toString(): String {
        return "WorkedOn(id=$id, person=${person.id}, product=${product.id}, startDate=$startDate, durationInWeeks=$durationInWeeks, role='$role')"
    }

    override fun hashCode(): Int {
        return Objects.hash(person.name, product.name, startDate, durationInWeeks, role)
    }

    override fun equals(other: Any?): Boolean {
        return ((this === other || other is WorkedOn)
            && person.name == other.person.name
            && product.name == other.product.name
            && startDate == other.startDate
            && durationInWeeks == other.durationInWeeks
            && role == other.role
            )
    }
}
