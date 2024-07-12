package com.example.escooters.screen.scooters.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.escooters.screen.data.model.Scooter
import com.example.escooters.screen.scooters.uistate.ScooterListUiState

@Composable
fun ScootersListScreen(
    uiState: ScooterListUiState = ScooterListUiState.Loading,
    onScooterClick: (Scooter) -> Unit,
) {
    when (uiState) {
        is ScooterListUiState.Error -> {
            Box(
                modifier =
                    Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                contentAlignment = Alignment.Center,
            ) {
                Text(text = uiState.message)
            }
        }

        is ScooterListUiState.Loading -> {
            Box(
                modifier =
                    Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                contentAlignment = Alignment.Center,
            ) {
                CircularProgressIndicator()
            }
        }

        is ScooterListUiState.Success -> {
            val scooters = uiState.scooterResponse.scooters
            val cityName = uiState.scooterResponse.name
            Column(
                modifier =
                    Modifier
                        .padding(vertical = 50.dp, horizontal = 16.dp)
                        .fillMaxWidth(),
            ) {
                Text(
                    text = cityName,
                    fontWeight = FontWeight.Bold,
                )
                Spacer(modifier = Modifier.height(6.dp))
                ScooterList(scooters, onScooterClick)
            }
        }
    }
}

@Composable
fun ScooterList(
    scooters: List<Scooter>,
    onScooterClick: (Scooter) -> Unit,
) {
    LazyColumn(
        modifier =
            Modifier
                .fillMaxSize()
                .padding(16.dp),
    ) {
        items(scooters) { scooter ->
            ScooterListItem(scooter, onScooterClick)
        }
    }
}

@Composable
fun ScooterListItem(
    scooter: Scooter,
    onScooterClick: (Scooter) -> Unit,
) {
    Card(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .clickable { onScooterClick(scooter) },
    ) {
        Column(
            modifier =
                Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
        ) {
            Text(
                text = scooter.name,
                fontWeight = FontWeight.Bold,
            )
            Spacer(modifier = Modifier.height(4.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Battery: ${scooter.battery}%")
                Spacer(modifier = Modifier.weight(1f))
                val availabilityText = if (scooter.inUse) "In Use" else "Available"
                Text(text = availabilityText, color = if (scooter.inUse) Color.Red else Color.Green)
            }
        }
    }
}
