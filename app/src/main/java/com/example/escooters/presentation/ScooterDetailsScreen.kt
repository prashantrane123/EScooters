package com.example.escooters.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.escooters.data.model.Scooter

@Composable
fun ScooterDetailsScreen(
    scooter: Scooter
){
Box(modifier =  Modifier.padding(vertical = 50.dp, horizontal = 16.dp)) {
    Card(
        modifier =
        Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
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
}