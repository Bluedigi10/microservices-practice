package com.bluedigi.microservices.controllers

import com.bluedigi.microservices.models.Producto
import com.bluedigi.microservices.services.IProductoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductsController {
    @Autowired
    lateinit var service: IProductoService

    @GetMapping("/list")
    fun list(): List<Producto>{
        return service.findAll()
    }

    @GetMapping("/find/{id}")
    fun find(@PathVariable id: Long): Producto{
        return service.findById(id)
    }
}