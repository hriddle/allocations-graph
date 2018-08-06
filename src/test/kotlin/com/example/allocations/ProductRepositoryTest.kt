package com.example.allocations

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
import com.example.allocations.person.PersonRepository
import com.example.allocations.product.ProductRepository
import org.amshove.kluent.`should equal`
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
        productRepository.deleteAll()
        personRepository.deleteAll()

        loadPeople()
        loadProducts()
        addRelationships()
    }

    @Test
    fun testGraph() {
        val graph = productRepository.findAll().toList()

        graph.size `should equal` 4

        graph.forEach {
            when {
                it.name == terryKitties.name -> it.team.size `should equal` 2
                it.name == fullBoyle.name -> it.team.size `should equal` 3
                it.name == puzzleMaster.name -> it.team.size `should equal` 1
                it.name == coralPalms.name -> it.team.size `should equal` 0
            }
        }
    }

    private fun loadPeople() {
        personRepository.save(rosa)
        personRepository.save(amy)
        personRepository.save(jake)
        personRepository.save(terry)
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
