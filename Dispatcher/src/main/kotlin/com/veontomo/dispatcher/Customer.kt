package com.veontomo.dispatcher

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Customer(@JsonProperty("firstname") val firstName: String, @JsonProperty("lastname") val lastName: String) {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private var id: Long = 0

    constructor() : this("", "")

    override public fun toString(): String {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }
}