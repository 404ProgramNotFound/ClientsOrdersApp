package it.blank.clientsorders.screen

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import it.blank.clientsorders.model.Order

class OrderViewModel : ViewModel() {
    private val _orders = mutableStateListOf<String>()
    val orders : List<String> get() = _orders

    fun addOrder(){
        _orders.add("")
    }
    fun removeOrder(){
        _orders.removeAt(_orders.lastIndex)
    }
}