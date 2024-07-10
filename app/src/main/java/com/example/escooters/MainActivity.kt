package com.example.escooters

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.escooters.presentation.ScootersListScreen
import com.example.escooters.presentation.ScootersViewModel
import com.example.escooters.ui.theme.EScootersTheme

class MainActivity : ComponentActivity() {
    private val scootersViewModel: ScootersViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EScootersTheme {
                val uiState = scootersViewModel.scootersListState.collectAsState()
                ScootersListScreen(uiState.value) {
                    Toast.makeText(baseContext, "${it.name}", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}
