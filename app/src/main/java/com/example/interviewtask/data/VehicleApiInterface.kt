package com.example.interviewtask.data

import com.example.interviewtask.data.dto.VehicleDetailDto
import retrofit2.http.GET

interface VehicleApiInterface {
    @GET("/c/0a86-25a4-4e67-9432")
    suspend fun fetchVehicleDetails() : List<VehicleDetailDto>
}