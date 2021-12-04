package com.denisg.mercadolivro.extension

import com.denisg.mercadolivro.controller.dto.CustomerDto
import com.denisg.mercadolivro.model.CustomerModel

fun CustomerDto.toCustomerModel(): CustomerModel{
    return CustomerModel(name = this.name, email = this.email)
}