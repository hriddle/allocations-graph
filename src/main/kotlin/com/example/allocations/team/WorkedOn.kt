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
    @Property var endDate: LocalDate = LocalDate.MAX,
    @Property var company: String = UNKNOWN,
    @Property var role: String = UNKNOWN
) {

    override fun toString(): String {
        return "WorkedOn(id=$id, person=${person.id}, product=${product.id}, startDate=$startDate, endDate=$endDate, company=$company, role='$role')"
    }

    override fun hashCode(): Int {
        return Objects.hash(person.name, product.name, startDate, endDate, company, role)
    }

    override fun equals(other: Any?): Boolean {
        return ((this === other || other is WorkedOn)
            && person.name == other.person.name
            && product.name == other.product.name
            && startDate == other.startDate
            && endDate == other.endDate
            && company == other.company
            && role == other.role
            )
    }
}
