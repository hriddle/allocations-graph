package com.example.allocations

import com.example.allocations.person.Person
import com.example.allocations.person.PersonNode
import com.example.allocations.person.ProductHistory
import com.example.allocations.person.toNode
import com.example.allocations.product.Product
import com.example.allocations.product.ProductNode
import com.example.allocations.product.toNode
import com.example.allocations.team.TeamPerson
import com.example.allocations.team.WorkedOn
import org.amshove.kluent.shouldEqual
import org.junit.Before
import org.junit.Test
import java.time.LocalDate

class NodeTranslatorTest {

    @Before
    fun setUp() {
        rosaNode.workedOn.add(rosaWorkedOnProduct)
        mooMooNode.team.add(rosaWorkedOnProduct)
    }

    @Test
    fun `translating PersonNode to Person should build Person object`() {
        Person.fromNode(rosaNode) shouldEqual rosa
    }

    @Test
    fun `translating Person to PersonNode should build PersonNode object`() {
        rosa.toNode() shouldEqual rosaNode
    }

    @Test
    fun `translating ProductNode to Product should build Product object`() {
        Product.fromNode(mooMooNode) shouldEqual mooMoo
    }

    @Test
    fun `translating Product to ProductNode should build Person object`() {
        mooMoo.toNode() shouldEqual mooMooNode
    }

    private val rosaNode = PersonNode(
        id = 78912,
        name = "Rosa Diaz",
        company = "NYPD",
        role = "DETECTIVE",
        level = "SECOND"
    )

    private val mooMooNode = ProductNode(
        id = 432,
        name = "Moo Moo",
        techStack = listOf("burglary", "arson"),
        startDate = LocalDate.of(2018, 4, 1)
    )

    private val rosaWorkedOnProduct = WorkedOn(
        id = 888,
        person = rosaNode,
        product = mooMooNode,
        startDate = LocalDate.of(2018, 4, 2),
        endDate = LocalDate.of(2018, 4, 16),
        company = "NYPD",
        role = "DETECTIVE"
    )

    private val rosa = Person(
        id = 78912,
        name = "Rosa Diaz",
        company = "NYPD",
        role = "DETECTIVE",
        level = "SECOND",
        productHistory = listOf(ProductHistory(
            id = 432,
            name = "Moo Moo",
            startDate = LocalDate.of(2018, 4, 2),
            endDate = LocalDate.of(2018, 4, 16)
        ))
    )

    private val mooMoo = Product(
        id = 432,
        name = "Moo Moo",
        techStack = listOf("burglary", "arson"),
        startDate = LocalDate.of(2018, 4, 1),
        endDate = LocalDate.MAX,
        team = listOf(TeamPerson(
            id = 78912,
            name = "Rosa Diaz",
            company = "NYPD",
            role = "DETECTIVE",
            startDate = LocalDate.of(2018, 4, 2),
            endDate = LocalDate.of(2018, 4, 16)
        ))
    )
}