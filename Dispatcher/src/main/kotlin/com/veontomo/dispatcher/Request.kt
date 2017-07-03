package com.veontomo.dispatcher

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Request(val size: Long) {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)

    private var id: Long = 0

    constructor() : this(0)

    override public fun toString(): String {
        return String.format(
                "Request[size=%d]", id)
    }
}