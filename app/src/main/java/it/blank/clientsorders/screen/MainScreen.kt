@file:OptIn(ExperimentalMaterial3Api::class)

package it.blank.clientsorders.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import it.blank.clientsorders.components.OrderCard
import it.blank.clientsorders.ui.theme.AppTypography

@Preview
@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        contentColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                title = { Text("Ordini", color = MaterialTheme.colorScheme.onTertiaryContainer, fontSize = MaterialTheme.typography.headlineMedium.fontSize) },
                colors = TopAppBarDefaults.topAppBarColors(MaterialTheme.colorScheme.tertiaryContainer)
                )
        }) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxWidth(),
            contentPadding = PaddingValues(16.dp)
        ) {
            item{
                OrderCard()
            }
            item{
                OrderCard()
            }
            item{
                OrderCard()
            }
            item{
                OrderCard()
            }
            item{
                OrderCard()
            }
            item{
                OrderCard()
            }
            item{
                OrderCard()
            }
            item{
                OrderCard()
            }
            item{
                OrderCard()
            }
            item{
                OrderCard()
            }

        }
    }
}