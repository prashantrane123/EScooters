package com.example.escooters

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import com.example.escooters.presentation.ScootersListScreen
import com.example.escooters.presentation.ScootersViewModel
import com.example.escooters.ui.theme.EScootersTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val scootersViewModel: ScootersViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EScootersTheme {
                val uiState = scootersViewModel.scootersListState.collectAsState()
                ScootersListScreen(uiState.value) {
                    Toast.makeText(baseContext, it.name, Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}
