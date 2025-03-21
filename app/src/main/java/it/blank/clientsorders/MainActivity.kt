package it.blank.clientsorders

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import it.blank.clientsorders.screen.OrderScreen
import it.blank.clientsorders.ui.theme.ClientsOrdersTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ClientsOrdersTheme {
                App()
            }
        }
    }
}

@Composable
fun App(modifier: Modifier = Modifier) {
    OrderScreen()

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ClientsOrdersTheme {
        App()
    }
}