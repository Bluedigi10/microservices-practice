package com.bluedigi.microservices.interfaces

import com.bluedigi.microservices.models.Producto
import org.springframework.data.repository.CrudRepository

interface ProductoInterface: CrudRepository<Producto, Long> {
}