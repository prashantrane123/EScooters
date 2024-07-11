package com.example.escooters.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.escooters.data.model.Scooter
import com.example.escooters.data.model.ScootersResponse
import com.example.escooters.data.repository.ScootersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScootersViewModel @Inject constructor(
    private val scootersRepository: ScootersRepository
) : ViewModel() {

    private val mutableScootersListUiState = MutableStateFlow<ScooterListUiState>(ScooterListUiState.Loading)
    val scootersListState = mutableScootersListUiState.asStateFlow()

    init {
        viewModelScope.launch {
            mutableScootersListUiState.value = ScooterListUiState.Loading

            scootersRepository.getScooters().collect {
                mutableScootersListUiState.value = ScooterListUiState.Success(it)
            }
        }
    }

    sealed class ScooterListUiState {

        data object Loading : ScooterListUiState()
        data class Success(val scooterResponse: ScootersResponse) : ScooterListUiState()
        data class Error(val message: String) : ScooterListUiState()
    }
}
