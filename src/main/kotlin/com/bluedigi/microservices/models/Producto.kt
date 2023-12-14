package com.bluedigi.microservices.models

import jakarta.persistence.*
import jakarta.persistence.Entity
import java.io.Serializable
import java.util.Date

@Table(name = "productos")
@Entity
data class Producto(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val nombre: String,
    val precio: Double,
    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    val createAt: Date,
    @Transient
    var port: Int
): Serializable
