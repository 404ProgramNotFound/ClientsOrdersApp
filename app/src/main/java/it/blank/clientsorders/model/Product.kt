package it.blank.clientsorders.model

import androidx.room.Entity

@Entity
data class Product(
    val id : Int,
    val name: String,
    val pricePerUnit: Float
)