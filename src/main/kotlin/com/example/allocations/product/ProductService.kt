package com.example.allocations.product

import com.example.allocations.toNullable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ProductService(val productRepository: ProductRepository) {

    @Transactional(readOnly = true)
    fun findAllProducts(): List<Product> =
        productRepository.findAll().map { Product.fromNode(it) }

    @Transactional(readOnly = true)
    fun findProductById(id: Long): Product? =
        productRepository.findById(id).toNullable()?.let { Product.fromNode(it) }

    @Transactional
    fun saveProduct(product: Product): Product {
        return productRepository.save(
            ProductNode(name = product.name, description = product.description, techStack = product.techStack, startDate = product.startDate)
        ).let { Product.fromNode(it) }
    }

}
