package com.denisg.mercadolivro.repository

import com.denisg.mercadolivro.model.CustomerModel
import org.springframework.data.repository.CrudRepository

interface CustomerRepository : CrudRepository<CustomerModel, Int>{

    fun findByNameContaining(name: String): List<CustomerModel>

}