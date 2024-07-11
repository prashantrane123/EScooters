package com.example.escooters

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.escooters.screen.data.model.Scooter
import com.example.escooters.screen.scooterdetails.view.ScooterDetailsScreen
import com.example.escooters.screen.scooters.view.ScootersListScreen
import com.example.escooters.screen.scooters.viewmodel.ScootersViewModel
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
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = ScooterScreenRoute) {
                    composable<ScooterScreenRoute> {
                        ScootersListScreen(uiState.value) {
                            navController.navigate(
                                ScooterDetailScreenRoute(
                                    id = it.id,
                                    name = it.name,
                                    battery = it.battery,
                                    inUse = it.inUse,
                                    needFix = it.needFix,
                                    totalRides = it.totalRides,
                                )
                            )
                        }
                    }

                    composable<ScooterDetailScreenRoute> {
                        val args = it.toRoute<ScooterDetailScreenRoute>()
                        ScooterDetailsScreen(
                            Scooter(
                                id = args.id,
                                name = args.name,
                                battery = args.battery,
                                inUse = args.inUse,
                                needFix = args.needFix,
                                totalRides = args.totalRides,
                            ),
                        )
                    }
                }
            }
        }
    }
}


