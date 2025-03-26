package it.blank.clientsorders.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import it.blank.clientsorders.model.Product
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDatabaseDao {
    @Query("SELECT * FROM products")
    fun getAllProduct(): Flow<List<Product>>

    @Query("SELECT * FROM products WHERE id = :id")
    suspend fun getProductById(id: String): Product

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProduct(product: Product)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateProduct(product: Product)

    @Query("DELETE FROM products")
    suspend fun deleteProducts()

    @Delete
    suspend fun deleteProduct(product: Product)
}