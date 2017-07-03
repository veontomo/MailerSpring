package com.veontomo.dispatcher

import org.springframework.data.repository.CrudRepository

interface RequestRepository: CrudRepository<Request, Long> {
}