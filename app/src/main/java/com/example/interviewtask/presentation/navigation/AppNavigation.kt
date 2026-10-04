package com.example.interviewtask.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.interviewtask.presentation.components.vehicledetail.VehicleDetailScreen
import com.example.interviewtask.presentation.components.vehiclelist.VehicleListScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = VehicleListRoute
    ) {
composable<VehicleListRoute> {
    VehicleListScreen(
        onVehicleClick = {
            id ->
            navController.navigate(VehicleDetailRoute(vehicleId = id))
        }
    )
}

        composable<VehicleDetailRoute> {
            VehicleDetailScreen({navController.popBackStack()})
        }

    }
}