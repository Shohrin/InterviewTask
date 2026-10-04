package com.example.interviewtask.presentation.navigation

import kotlinx.serialization.Serializable

@Serializable
object VehicleListRoute

@Serializable
data class VehicleDetailRoute(val vehicleId: Int)
