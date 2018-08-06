package com.example.allocations

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories

@SpringBootApplication
@EnableNeo4jRepositories
class AllocationsApplication

fun main(args: Array<String>) {
    runApplication<AllocationsApplication>(*args)
}
