package com.example.interviewtask.domain.model

data class VehicleDetailModel(
    val id: Int,
    val name: String,
    val model: String,
    val status: String,
    val connectivityStatus: String,
    val batteryPercent: Int,
    val currentSpeed: Int,
    val estimatedRange: Int,
    val odometer: Int,
    val lastUpdateTime: String
)

