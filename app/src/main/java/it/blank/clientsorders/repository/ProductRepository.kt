package it.blank.clientsorders.repository

import it.blank.clientsorders.data.ProductDatabaseDao
import it.blank.clientsorders.model.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val productDatabaseDao: ProductDatabaseDao
) {
    suspend fun addOrder(product: Product) = productDatabaseDao.addProduct(product)
    suspend fun updateOrder(product: Product) = productDatabaseDao.updateProduct(product)
    suspend fun deleteOrders() = productDatabaseDao.deleteProducts()
    suspend fun deleteOrder(product: Product) = productDatabaseDao.deleteProduct(product)
    suspend fun getOrderById(id: String) = productDatabaseDao.getProductById(id)
    fun getAllOrders(): Flow<List<Product>> =
        productDatabaseDao.getAllProduct().flowOn(Dispatchers.IO).conflate()
}