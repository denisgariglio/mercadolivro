package com.denisg.mercadolivro.service

import com.denisg.mercadolivro.controller.dto.CustomerDto
import com.denisg.mercadolivro.model.CustomerModel
import com.denisg.mercadolivro.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(val customerRepository: CustomerRepository) {

    val customers = mutableListOf<CustomerModel>()

    fun getAll(name: String?): List<CustomerModel> {
        name?.let {
            return customerRepository.findByNameContaining(it) }

        return customerRepository.findAll().toList()
    }

    fun getById(id: Int): CustomerModel {
        return customerRepository.findById(id).get()
    }

    fun update(id: Int, customer: CustomerDto) {
        if(!customerRepository.existsById(id)){
            throw Exception()
        }

        customerRepository.save(CustomerModel(id, customer.name, customer.email))
    }

    fun delete(id: Int) {
        if(!customerRepository.existsById(id)){
            throw Exception()
        }

        customerRepository.deleteById(id)

    }

    fun create(customer: CustomerModel) {
        customerRepository.save(customer)
    }
}