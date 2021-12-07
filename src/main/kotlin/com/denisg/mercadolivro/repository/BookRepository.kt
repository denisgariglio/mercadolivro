package com.denisg.mercadolivro.repository

import com.denisg.mercadolivro.model.BookModel
import org.springframework.data.repository.CrudRepository

interface BookRepository : CrudRepository<BookModel, Int> {
}