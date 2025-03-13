package it.blank.clientsorders.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import it.blank.clientsorders.model.Order
import it.blank.clientsorders.model.Product
import it.blank.clientsorders.util.DateConverter
import it.blank.clientsorders.util.ProductsIdListConverter

@TypeConverters(DateConverter::class, ProductsIdListConverter::class)
@Database(entities = [Order::class,Product::class], version = 1, exportSchema = false)
abstract class OrderDatabase : RoomDatabase() {
    abstract fun orderDao() : OrderDatabaseDao
    abstract fun productDao() : ProductDatabaseDao
}