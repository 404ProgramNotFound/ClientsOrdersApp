package it.blank.clientsorders.repository

import it.blank.clientsorders.data.OrderDatabaseDao
import it.blank.clientsorders.model.Order
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class OrderRepository @Inject constructor(
    private val orderDatabaseDao: OrderDatabaseDao
) {
    suspend fun addOrder(order: Order) = orderDatabaseDao.addOrder(order)
    suspend fun updateOrder(order: Order) = orderDatabaseDao.updateOrder(order)
    suspend fun deleteOrders() = orderDatabaseDao.deleteOrders()
    suspend fun deleteOrder(order: Order) = orderDatabaseDao.deleteOrder(order)
    suspend fun getOrderById(id: String) = orderDatabaseDao.getOrderById(id)
    fun getAllOrders(): Flow<List<Order>> =
        orderDatabaseDao.getAllOrders().flowOn(Dispatchers.IO).conflate()
}