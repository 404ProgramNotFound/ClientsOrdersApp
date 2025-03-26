package it.blank.clientsorders

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.AndroidEntryPoint
import it.blank.clientsorders.model.Order
import it.blank.clientsorders.screen.OrderScreen
import it.blank.clientsorders.ui.theme.ClientsOrdersTheme
import it.blank.clientsorders.viewModel.OrderViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ClientsOrdersTheme {
                val orderViewModel = viewModel<OrderViewModel>()
                App(orderViewModel = orderViewModel)
            }
        }
    }
}

@Composable
fun App(modifier: Modifier = Modifier, orderViewModel: OrderViewModel) {
    val orderList: List<Order> = orderViewModel.orderList.collectAsState().value
    OrderScreen(
        orders = orderList,
        onAddOrder = {
            orderViewModel.addOrder(it)
        },
        onRemoveOrder = {
            orderViewModel.deleteOrder(it)
        }
    )

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ClientsOrdersTheme {

    }
}