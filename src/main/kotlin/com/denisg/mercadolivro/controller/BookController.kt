package com.denisg.mercadolivro.controller

import com.denisg.mercadolivro.controller.dto.BookRequestDto
import com.denisg.mercadolivro.extension.toBookModel
import com.denisg.mercadolivro.service.BookService
import com.denisg.mercadolivro.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("book")
class BookController(
    val bookService: BookService,
    val customerService: CustomerService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody request: BookRequestDto){
        val customer = customerService.getById(request.customerId)
        bookService.create(request.toBookModel(customer))
    }

}