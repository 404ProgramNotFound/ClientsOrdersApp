@file:OptIn(ExperimentalMaterial3Api::class)

package it.blank.clientsorders.screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import it.blank.clientsorders.components.OrderCard

@Preview
@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val ordersList = remember {
        mutableStateListOf<String>()
    }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        contentColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Ordini",
                        color = MaterialTheme.colorScheme.onTertiaryContainer,
                        fontSize = MaterialTheme.typography.headlineMedium.fontSize
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(MaterialTheme.colorScheme.tertiaryContainer),

                )
        },
        bottomBar = {
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                contentColor = MaterialTheme.colorScheme.onTertiaryContainer
            ) {
                NavigationBarItem(
                    selected = false,
                    onClick = { ordersList.add("") },
                    icon = { Icon(Icons.Default.Add, contentDescription = "add") })
                NavigationBarItem(
                    selected = false,
                    onClick = { ordersList.add("") },
                    icon = { Icon(Icons.Default.Add, contentDescription = "add") })
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxWidth(),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(items = ordersList) { order ->
                OrderCard()
            }

        }
    }
}