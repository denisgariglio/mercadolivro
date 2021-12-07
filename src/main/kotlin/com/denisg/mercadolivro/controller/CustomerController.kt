package com.denisg.mercadolivro.controller

import com.denisg.mercadolivro.controller.dto.CustomerDto
import com.denisg.mercadolivro.extension.toCustomerModel
import com.denisg.mercadolivro.model.CustomerModel
import com.denisg.mercadolivro.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("customers")
class CustomerController(val customerService: CustomerService) {

    @GetMapping
    fun getAll(@RequestParam name: String?): List<CustomerModel> {
        return customerService.getAll(name)
    }

    @GetMapping("/{id}")
    fun getCustomer(@PathVariable id: Int): CustomerModel {
        return customerService.getById(id)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int, @RequestBody customer: CustomerDto) {
        customerService.update(id, customer)

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int) {
        customerService.delete(id)

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody customer: CustomerDto) {
        customerService.create(customer.toCustomerModel())
    }

}