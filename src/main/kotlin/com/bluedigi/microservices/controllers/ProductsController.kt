package com.bluedigi.microservices.controllers

import com.bluedigi.microservices.models.Producto
import com.bluedigi.microservices.services.IProductoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.TimeUnit

@RestController
class ProductsController {

    @Autowired
    lateinit var env: Environment

    @Autowired
    lateinit var service: IProductoService

    @GetMapping("/list")
    fun list(): List<Producto> {
        return service.findAll().stream().map { p ->
            p.port = Integer.parseInt(env.getProperty("local.server.port"))
            p
        }.toList()
    }

    @GetMapping("/find/{id}")
    fun find(@PathVariable id: Long): Producto {
        if (id == 1L) {
            throw IllegalStateException("Produto No encontrado")
        }
        if (id == 2L) {
            TimeUnit.SECONDS.sleep(5L)
        }
        var producto = Producto()
        try {
            producto = service.findById(id)
        }catch (e: Exception){
            println(e.message)
            throw IllegalStateException("Produto No encontrado")
        }
        producto.port = Integer.parseInt(env.getProperty("local.server.port"))
        return producto
    }
}