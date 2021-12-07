package com.denisg.mercadolivro.service

import com.denisg.mercadolivro.model.BookModel
import com.denisg.mercadolivro.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(
    val bookRepository: BookRepository
) {
    fun create(book: BookModel) {
        bookRepository.save(book)
    }

}
