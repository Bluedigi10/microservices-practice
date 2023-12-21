package com.bluedigi.microservices.models

import jakarta.persistence.*
import jakarta.persistence.Entity
import java.io.Serializable
import java.time.LocalDate
import java.util.Date

@Table(name = "productos")
@Entity
data class Producto(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,
    var nombre: String = "",
    var precio: Double = 0.0,
    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    val createAt: Date = Date(),
    @Transient
    var port: Int = 0
): Serializable
