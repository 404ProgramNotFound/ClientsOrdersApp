package it.blank.clientsorders.util

import androidx.room.TypeConverter

class ProductsIdListConverter {

    @TypeConverter
    fun dataFromProductsIdList(productsId: List<Int>): String{
        return productsId.joinToString()
    }

    @TypeConverter
    fun productsIdListFromData(data: String): List<Int>{
        return data.split(",").map { it.toInt() }
    }
}