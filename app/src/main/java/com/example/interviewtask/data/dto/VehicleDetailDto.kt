package com.example.interviewtask.data.dto


import android.os.Build
import com.example.interviewtask.domain.model.VehicleDetailModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Locale

@Serializable
data class VehicleDetailDto(
    @SerialName("batteryPercent")
    val batteryPercent: Int,
    @SerialName("connectivityStatus")
    val connectivityStatus: String,
    @SerialName("currentSpeed")
    val currentSpeed: Int,
    @SerialName("estimatedRange")
    val estimatedRange: Int,
    @SerialName("id")
    val id: Int,
    @SerialName("lastUpdateTime")
    val lastUpdateTime: String,
    @SerialName("model")
    val model: String,
    @SerialName("odometer")
    val odometer: Int,
    @SerialName("status")
    val status: String,
    @SerialName("vehicleName")
    val vehicleName: String
)

fun VehicleDetailDto.toVehicleModel(): VehicleDetailModel {


    return VehicleDetailModel(
        id = this.id,
        name = this.vehicleName,
        model = this.model,
        status = this.status,
        connectivityStatus = this.connectivityStatus,
        batteryPercent = this.batteryPercent,
        currentSpeed = this.currentSpeed,
        estimatedRange = this.estimatedRange,
        odometer = this.odometer,
        // Parses the ISO-8601 string (e.g., "2026-10-03T17:32:00Z") to Instant
        lastUpdateTime = this.lastUpdateTime)

}
