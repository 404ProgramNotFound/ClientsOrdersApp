package it.blank.clientsorders.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import it.blank.clientsorders.data.OrderDatabase
import it.blank.clientsorders.data.OrderDatabaseDao
import it.blank.clientsorders.data.ProductDatabaseDao
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun provideProductDao(productDatabase: OrderDatabase): ProductDatabaseDao =
        productDatabase.productDao()

    @Singleton
    @Provides
    fun provideOrderDao(orderDatabase: OrderDatabase): OrderDatabaseDao = orderDatabase.orderDao()

    @Singleton
    @Provides
    fun provideOrderDatabase(@ApplicationContext context: Context): OrderDatabase =
        Room.databaseBuilder(context, OrderDatabase::class.java, "products_orders_db")
            .fallbackToDestructiveMigration().build()
}