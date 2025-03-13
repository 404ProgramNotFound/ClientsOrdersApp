package it.blank.clientsorders.repository

import it.blank.clientsorders.data.OrderDatabaseDao
import it.blank.clientsorders.data.ProductDatabaseDao
import javax.inject.Inject

class OrderRepository @Inject constructor(
    private val orderDatabaseDao: OrderDatabaseDao,
    private val productDatabaseDao: ProductDatabaseDao
)