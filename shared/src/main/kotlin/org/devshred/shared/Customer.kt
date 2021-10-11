package org.devshred.shared

import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int? = null

    @Column(nullable = false)
    lateinit var name: String

    @Column(nullable = true)
    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true)
    var addresses: MutableList<Address> = mutableListOf()

    fun addAddress(address: Address) {
        addresses.add(address)
    }

    fun replaceAddress(address: Address) {
        addresses.clear()
        addresses.add(address)
    }
}