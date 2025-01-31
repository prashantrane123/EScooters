package com.example.escooters.screen.scooters.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.escooters.screen.data.repository.ScootersRepository
import com.example.escooters.screen.scooters.uistate.ScooterListUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScootersViewModel
    @Inject
    constructor(
        private val scootersRepository: ScootersRepository,
    ) : ViewModel() {
        private val mutableScootersListUiState = MutableStateFlow<ScooterListUiState>(ScooterListUiState.Loading)
        val scootersListState = mutableScootersListUiState.asStateFlow()

        private val exceptionHandler =
            CoroutineExceptionHandler { _, _ ->
                mutableScootersListUiState.value = ScooterListUiState.Error("Some Exception Occured")
            }

        init {
            viewModelScope.launch(exceptionHandler) {
                mutableScootersListUiState.value = ScooterListUiState.Loading

                scootersRepository.getScooters().collect {
                    mutableScootersListUiState.value = ScooterListUiState.Success(it)
                }
            }
        }
    }
