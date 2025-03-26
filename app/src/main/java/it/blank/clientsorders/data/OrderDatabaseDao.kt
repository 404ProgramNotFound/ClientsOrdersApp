package it.blank.clientsorders.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import it.blank.clientsorders.model.Order
import kotlinx.coroutines.flow.Flow

@Dao
interface OrderDatabaseDao {
    @Query("SELECT * FROM orders")
    fun getAllOrders(): Flow<List<Order>>

    @Query("SELECT * FROM orders WHERE id = :id")
    suspend fun getOrderById(id: String): Order

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addOrder(order: Order)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateOrder(order: Order)

    @Query("DELETE FROM orders")
    suspend fun deleteOrders()

    @Delete
    suspend fun deleteOrder(order: Order)

}