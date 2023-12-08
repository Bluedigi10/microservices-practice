package com.bluedigi.microservices.services

import com.bluedigi.microservices.models.Producto

interface IProductoService {
    fun findAll(): List<Producto>
    fun findById(id: Long): Producto
}