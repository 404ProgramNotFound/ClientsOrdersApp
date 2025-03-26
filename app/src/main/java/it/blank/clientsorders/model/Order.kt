package it.blank.clientsorders.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant
import java.util.Date
import java.util.UUID

@Entity(tableName = "orders")
data class Order(

    @PrimaryKey val id: UUID = UUID.randomUUID(),

    @ColumnInfo(name = "title") val title: String,

    @ColumnInfo(name = "products") val productsId: List<Int>,

    @ColumnInfo(name = "customer") val customer: String,

    @ColumnInfo(name = "entryDate") val entryDate: Date = Date.from(Instant.now()),

    @ColumnInfo(name = "total") val total: Float = 0f,
)