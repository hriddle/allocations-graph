package com.example.allocations.person

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.example.allocations.UNKNOWN
import com.example.allocations.team.WorkedOn
import org.neo4j.ogm.annotation.GeneratedValue
import org.neo4j.ogm.annotation.Id
import org.neo4j.ogm.annotation.NodeEntity
import org.neo4j.ogm.annotation.Relationship
import org.springframework.data.neo4j.repository.Neo4jRepository
import org.springframework.stereotype.Repository
import java.util.ArrayList
import java.util.Objects

@Repository
interface PersonRepository : Neo4jRepository<PersonNode, Long>

@NodeEntity(label = "Person")
data class PersonNode(
    @Id @GeneratedValue var id: Long = -1,
    var name: String = "",
    var role: String = UNKNOWN,
    var level: String = UNKNOWN,
    @JsonIgnoreProperties("person")
    @Relationship(type = "WORKED_ON", direction = Relationship.OUTGOING)
    var workedOn: ArrayList<WorkedOn> = ArrayList()
) {

    override fun toString(): String {
        return "PersonNode(id=$id, name='$name', role='$role', level='$level')"
    }

    override fun equals(other: Any?): Boolean {
        return ((this === other || other is PersonNode)
            && name == other.name
            && role == other.role
            && level == other.level
            )
    }
    override fun hashCode(): Int {
        return Objects.hash(name, role, level)
    }
}

fun Person.toNode(): PersonNode = PersonNode(
    id = this.id,
    name = this.name,
    role = this.role,
    level = this.level
)