package org.devshred.shared

import io.github.serpro69.kfaker.faker
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.net.URI
import java.util.Optional

@RestController
class CustomerController @Autowired constructor(
    private val customerRepository: CustomerRepository
) {
    private val faker = faker { }

    @GetMapping("/count")
    fun count(): ResponseEntity<Long> = ResponseEntity.ok(customerRepository.count())

    @GetMapping("/all")
    fun all(): ResponseEntity<MutableIterable<Customer>> = ResponseEntity.ok(customerRepository.findAll())

    @GetMapping("/create")
    fun createCustomer(): ResponseEntity<String> {
        val customer = randomCustomer()
        val customerId = customerRepository.save(customer).id
        return ResponseEntity
            .created(URI.create("/customer/$customerId"))
            .body("created")
    }

    @GetMapping("/createWithAddress")
    fun createCustomerWithAddress(): ResponseEntity<String> {
        val customer = randomCustomer()
        customer.addAddress(randomAddress())
        val customerId = customerRepository.save(customer).id
        return ResponseEntity
            .created(URI.create("/customer/$customerId"))
            .body("created")
    }

    @GetMapping("/addAddress/{id}")
    fun addAddressToCustomer(@PathVariable("id") id: Int): ResponseEntity<String> {
        customerRepository.findById(id).value?.let { customer ->
            customer.addAddress(randomAddress())
            customerRepository.save(customer)
            return ResponseEntity.noContent().build()
        }
        return ResponseEntity.notFound().build()
    }

    @GetMapping("/changeAddress/{id}")
    fun changeAddressOfCustomer(@PathVariable("id") id: Int): ResponseEntity<String> {
        customerRepository.findById(id).value?.let { customer ->
            customer.replaceAddress(randomAddress())
            customerRepository.save(customer)
            return ResponseEntity.noContent().build()
        }
        return ResponseEntity.notFound().build()
    }

    private fun randomCustomer() = Customer().apply { name = faker.name.firstName() }
    private fun randomAddress() = Address().apply { street = faker.address.streetName() }

    private val <T> Optional<T>.value: T? get() = orElse(null)
}