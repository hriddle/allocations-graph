package com.example.allocations.product

import com.example.allocations.asInsert
import com.example.allocations.json
import com.example.allocations.product.MockProduct.coralPalms
import com.example.allocations.product.MockProduct.fullBoyle
import com.example.allocations.product.MockProduct.puzzleMaster
import com.example.allocations.product.MockProduct.terryKitties
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Before
import org.junit.Test
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.header
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders

class ProductControllerTest {

    private lateinit var mockMvc: MockMvc

    private val mockProductService: ProductService = mock {
        whenever(it.findAllProducts()) doReturn listOf(fullBoyle, puzzleMaster, terryKitties, coralPalms)

        whenever(it.findProductById(1)) doReturn fullBoyle
        whenever(it.findProductById(2)) doReturn puzzleMaster
        whenever(it.findProductById(3)) doReturn terryKitties
        whenever(it.findProductById(4)) doReturn coralPalms

        whenever(it.saveProduct(coralPalms.asInsert)) doReturn coralPalms
    }

    @Before
    fun setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(ProductController(service = mockProductService)).build()
    }

    @Test
    fun `GET product returns a 200 and a list of Products`() {
        mockMvc.perform(get("/products"))
            .andExpect(status().isOk)
            .andExpect(content().string("[${fullBoyle.json},${puzzleMaster.json},${terryKitties.json},${coralPalms.json}]"))

        verify(mockProductService).findAllProducts()
    }

    @Test
    fun `GET product returns a 200 and an empty list`() {
        whenever(mockProductService.findAllProducts()) doReturn emptyList<Product>()

        mockMvc.perform(get("/products"))
            .andExpect(status().isOk)
            .andExpect(content().string("[]"))

        verify(mockProductService).findAllProducts()
    }

    @Test
    fun `GET product by id returns a 200 and a Product`() {
        mockMvc.perform(get("/products/${puzzleMaster.id}"))
            .andExpect(status().isOk)
            .andExpect(content().string(puzzleMaster.json))

        verify(mockProductService).findProductById(puzzleMaster.id)
    }

    @Test
    fun `GET product by id returns a 404 when Product doesn't exist`() {
        val badId = 123L

        mockMvc.perform(get("/products/$badId"))
            .andExpect(status().isNotFound)
            .andExpect(content().string(""))

        verify(mockProductService).findProductById(badId)
    }

    @Test
    fun `POST product returns a 201 and the Product`() {
        mockMvc.perform(post("/products")
            .header("Content-Type", "application/json")
            .content(coralPalms.asInsert.json))
            .andExpect(status().isCreated)
            .andExpect(content().string(coralPalms.json))
            .andExpect(header().string("Location", "/products/${coralPalms.id}"))

        verify(mockProductService).saveProduct(coralPalms.asInsert)
    }
}