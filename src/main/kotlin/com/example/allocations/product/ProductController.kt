package com.example.allocations.product

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

const val products = "/products"

@RestController
@RequestMapping(products)
@CrossOrigin(allowCredentials = "true")
class ProductController(val service: ProductService) {

    @GetMapping("")
    fun getProducts(): List<Product> {
        return service.findAllProducts()
    }

    @GetMapping("/{id}")
    fun getProduct(@PathVariable id: Long): ResponseEntity<Product> {
        return service.findProductById(id)?.let {
            ResponseEntity.ok(it)
        } ?: ResponseEntity.notFound().build()
    }

    @PostMapping("")
    fun createPerson(@RequestBody product: Product): ResponseEntity<Any> =
        service.saveProduct(product).let {
            ResponseEntity.created(URI("$products/${it.id}")).body(it)
        }

}
