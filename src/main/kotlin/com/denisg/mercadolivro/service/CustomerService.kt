package com.denisg.mercadolivro.service

import com.denisg.mercadolivro.controller.dto.CustomerDto
import com.denisg.mercadolivro.model.CustomerModel
import org.springframework.stereotype.Service

@Service
class CustomerService {

    val customers = mutableListOf<CustomerModel>()

    fun getAll(name: String?): List<CustomerModel> {
        name?.let {
            return customers.filter { it.name.contains(name, ignoreCase = true) }
        }

        return customers
    }

    fun getCustomer(id: String): CustomerModel {
        return customers.filter { it.id == id }.first()
    }

    fun update(id: String, customer: CustomerDto) {
        customers.filter { it.id == id }.first().let {
            it.name = customer.name
            it.email = customer.email
        }
    }

    fun delete(id: String, customer: CustomerDto) {
        customers.removeIf { it.id == id}

    }

    fun create(customer: CustomerModel) {

        var id = if (customers.isEmpty()) "1" else (customers.last().id!!.toInt()+1).toString()

        customer.id = id
        customers.add(CustomerModel(id, customer.name, customer.email))
    }
}