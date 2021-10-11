package org.devshred.shared

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.argumentCaptor
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.never
import com.nhaarman.mockitokotlin2.whenever
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.hasSize
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito.verify
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import java.util.Optional


class CustomerControllerTest {
    private lateinit var mockMvc: MockMvc

    private val customerRepository = mock<CustomerRepository>()

    @BeforeEach
    fun setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(CustomerController(customerRepository)).build()
        whenever(customerRepository.save(any<Customer>()))
            .thenReturn(Customer().apply { id = 1; name = "dummy" })
    }

    @Test
    fun `requesting create - creates customer and returns 200`() {
        mockMvc.perform(MockMvcRequestBuilders.get("/create"))
            .andExpect(MockMvcResultMatchers.status().isCreated)

        verify(customerRepository).save(any())
    }

    @Test
    fun `requesting create with address - creates customer with address and returns 200`() {
        mockMvc.perform(MockMvcRequestBuilders.get("/createWithAddress"))
            .andExpect(MockMvcResultMatchers.status().isCreated)

        val captor = argumentCaptor<Customer>()
        verify(customerRepository).save(captor.capture())
        val customer = captor.firstValue
        assertThat(customer.addresses, hasSize(1))
    }

    @Test
    fun `adding address for existing customer - returns 204`() {
        val id = 1
        whenever(customerRepository.findById(id)).thenReturn(Optional.of(Customer()))

        mockMvc.perform(MockMvcRequestBuilders.get("/addAddress/$id"))
            .andExpect(MockMvcResultMatchers.status().isNoContent)

        verify(customerRepository).save(any())
    }

    @Test
    fun `adding address for nonexisting customer - returns 404`() {
        val id = 1
        whenever(customerRepository.findById(id)).thenReturn(Optional.empty())

        mockMvc.perform(MockMvcRequestBuilders.get("/addAddress/$id"))
            .andExpect(MockMvcResultMatchers.status().isNotFound)

        verify(customerRepository, never()).save(any())
    }

    @Test
    fun `changing address for existing customer - returns 204`() {
        val id = 1
        whenever(customerRepository.findById(id)).thenReturn(Optional.of(Customer()))

        mockMvc.perform(MockMvcRequestBuilders.get("/changeAddress/$id"))
            .andExpect(MockMvcResultMatchers.status().isNoContent)

        verify(customerRepository).save(any())
    }

    @Test
    fun `changing address for nonexisting customer - returns 404`() {
        val id = 1
        whenever(customerRepository.findById(id)).thenReturn(Optional.empty())

        mockMvc.perform(MockMvcRequestBuilders.get("/changeAddress/$id"))
            .andExpect(MockMvcResultMatchers.status().isNotFound)

        verify(customerRepository, never()).save(any())
    }
}