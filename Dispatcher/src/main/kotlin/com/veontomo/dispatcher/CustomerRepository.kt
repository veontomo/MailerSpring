package com.veontomo.dispatcher

import org.springframework.data.repository.CrudRepository

interface CustomerRepository : CrudRepository<Customer, Long> {
    fun findByLastName(name: String): List<Customer>
}
