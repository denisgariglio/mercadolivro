package com.denisg.mercadolivro.extension

import com.denisg.mercadolivro.controller.dto.BookRequestDto
import com.denisg.mercadolivro.controller.dto.CustomerDto
import com.denisg.mercadolivro.enums.BookStatus
import com.denisg.mercadolivro.model.BookModel
import com.denisg.mercadolivro.model.CustomerModel

fun CustomerDto.toCustomerModel(): CustomerModel{
    return CustomerModel(name = this.name, email = this.email)
}

fun BookRequestDto.toBookModel(customer: CustomerModel): BookModel{
    return BookModel(
        name = this.name,
        price = this.price,
        status = BookStatus.ATIVO,
        customer = customer
    )
}