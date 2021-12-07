package com.denisg.mercadolivro.model

import lombok.AllArgsConstructor
import lombok.NoArgsConstructor
import javax.persistence.*

@Entity(name = "customer")
@AllArgsConstructor
@NoArgsConstructor
data class CustomerModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,
    @Column
    var name: String,

    @Column
    var email: String
)