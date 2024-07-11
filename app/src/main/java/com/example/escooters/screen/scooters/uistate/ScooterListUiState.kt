package com.example.escooters.screen.scooters.uistate

import com.example.escooters.screen.data.model.ScootersResponse

sealed class ScooterListUiState {

    data object Loading : ScooterListUiState()
    data class Success(val scooterResponse: ScootersResponse) : ScooterListUiState()
    data class Error(val message: String) : ScooterListUiState()
}