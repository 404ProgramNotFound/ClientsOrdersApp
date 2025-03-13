package it.blank.clientsorders.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Product(

    @PrimaryKey(autoGenerate = true)
    val id : Int,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "pricePerUnit")
    val pricePerUnit: Float
)