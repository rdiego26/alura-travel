package me.diegoramos.aluratravel.model

import java.io.Serializable
import java.math.BigDecimal

class Package (
    val location: String,
    val image: String,
    val days: Int,
    val price: BigDecimal
) : Serializable