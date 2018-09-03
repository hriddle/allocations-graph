package com.example.allocations.product

import com.example.allocations.MockPersonNode.amy
import com.example.allocations.MockPersonNode.jake
import com.example.allocations.MockPersonNode.rosa
import com.example.allocations.MockPersonNode.terry
import com.example.allocations.MockProductNode.coralPalms
import com.example.allocations.MockProductNode.fullBoyle
import com.example.allocations.MockProductNode.puzzleMaster
import com.example.allocations.MockProductNode.terryKitties
import com.example.allocations.MockWorkedOnRelationship.fullBoyleDetectiveAmy
import com.example.allocations.MockWorkedOnRelationship.fullBoyleDetectiveJake
import com.example.allocations.MockWorkedOnRelationship.fullBoyleSergeantTerry
import com.example.allocations.MockWorkedOnRelationship.puzzleMasterDetectiveAmy
import com.example.allocations.MockWorkedOnRelationship.terryKittiesDetectiveAmy
import com.example.allocations.MockWorkedOnRelationship.terryKittiesSergeantTerry
import com.example.allocations.asInsert
import com.example.allocations.person.PersonRepository
import org.amshove.kluent.shouldEqual
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.neo4j.DataNeo4jTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@DataNeo4jTest
class ProductRepositoryTest {

    @Autowired
    lateinit var productRepository: ProductRepository

    @Autowired
    lateinit var personRepository: PersonRepository

    @Before
    fun setUp() {
        loadPeople()
        loadProducts()
        addRelationships()
    }

    @After
    fun tearDown() {
        productRepository.deleteAll()
        personRepository.deleteAll()
    }

    @Test
    fun `it returns the state of a product team at a certain date in time`() {
        productRepository.findProductsForDate("2018-08-01").toList().let { graph ->
            graph.size shouldEqual 1
            graph.first().let {
                it.name shouldEqual puzzleMaster.name
                it.team.size shouldEqual 1
                it.team.first().person.name = amy.name
            }
        }

        productRepository.findProductsForDate("2018-01-02").toList().let { graph ->
            graph.size shouldEqual 3
            graph.forEach {
                when {
                    it.name == terryKitties.name -> it.team.size shouldEqual 2
                    it.name == fullBoyle.name -> it.team.size shouldEqual 3
                    it.name == puzzleMaster.name -> it.team.size shouldEqual 1
                }
            }
        }
    }

    private fun loadPeople() {
        personRepository.save(rosa.asInsert)
        personRepository.save(amy.asInsert)
        personRepository.save(jake.asInsert)
        personRepository.save(terry.asInsert)
    }

    private fun loadProducts() {
        productRepository.save(fullBoyle)
        productRepository.save(puzzleMaster)
        productRepository.save(terryKitties)
        productRepository.save(coralPalms)
    }

    private fun addRelationships() {
        fullBoyle.team.add(fullBoyleDetectiveAmy)
        fullBoyle.team.add(fullBoyleDetectiveJake)
        fullBoyle.team.add(fullBoyleSergeantTerry)
        puzzleMaster.team.add(puzzleMasterDetectiveAmy)
        terryKitties.team.add(terryKittiesDetectiveAmy)
        terryKitties.team.add(terryKittiesSergeantTerry)

        amy.workedOn.add(fullBoyleDetectiveAmy)
        amy.workedOn.add(puzzleMasterDetectiveAmy)
        amy.workedOn.add(terryKittiesDetectiveAmy)
        jake.workedOn.add(fullBoyleDetectiveJake)
        terry.workedOn.add(fullBoyleSergeantTerry)
        terry.workedOn.add(terryKittiesSergeantTerry)

        personRepository.save(amy)
        personRepository.save(jake)
        personRepository.save(terry)
        productRepository.save(fullBoyle)
        productRepository.save(puzzleMaster)
        productRepository.save(terryKitties)
    }
}
