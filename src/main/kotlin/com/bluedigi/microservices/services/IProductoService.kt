package com.bluedigi.microservices.services

import com.bluedigi.microservices.models.Producto

interface IProductoService {
    fun findAll(): List<Producto>
    fun findById(id: Long): Producto

    fun save(producto: Producto): Producto

    fun delete(id: Long): String
}