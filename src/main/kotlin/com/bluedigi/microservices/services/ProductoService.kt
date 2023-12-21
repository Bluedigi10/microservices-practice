package com.bluedigi.microservices.services

import com.bluedigi.microservices.interfaces.ProductoInterface
import com.bluedigi.microservices.models.Producto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ProductoService: IProductoService {
    @Autowired
    lateinit var productoInterface: ProductoInterface

    @Transactional(readOnly = true)
    override fun findAll(): List<Producto> {
        val lista = productoInterface.findAll()
        return lista as MutableList<Producto>
    }

    @Transactional(readOnly = true)
    override fun findById(id: Long): Producto {
        return productoInterface.findById(id).orElse(null)
    }

    @Transactional
    override fun save(producto: Producto): Producto {
        return productoInterface.save(producto)
    }

    @Transactional
    override fun delete(id: Long): String {
        productoInterface.deleteById(id)
        return "borrado con exito"
    }

}