package it.blank.clientsorders.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import it.blank.clientsorders.model.Order
import it.blank.clientsorders.repository.OrderRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OrderViewModel @Inject constructor(
    private val orderRepository: OrderRepository
) : ViewModel() {
    private val _orderList = MutableStateFlow<List<Order>>(emptyList())
    val orderList = _orderList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            orderRepository.getAllOrders().distinctUntilChanged().collect { listOfOrder ->
                if (listOfOrder.isNotEmpty()) {
                    Log.d("ORDER_LIST", "la lista degli ordini è vuota")
                }
                _orderList.value = listOfOrder
            }
        }
    }

    fun addOrder(order: Order) = viewModelScope.launch {
        orderRepository.addOrder(order)
    }

    fun updateOrder(order: Order) = viewModelScope.launch {
        orderRepository.updateOrder(order)
    }

    fun deleteOrders() = viewModelScope.launch {
        orderRepository.deleteOrders()
    }

    fun deleteOrder(order: Order) = viewModelScope.launch {
        orderRepository.deleteOrder(order)
    }
}