package com.veontomo.dispatcher

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Customer(val firstName: String, val lastName: String) {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private var id: Long = 0

    constructor() : this("", "")

    override public fun toString(): String {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }
}