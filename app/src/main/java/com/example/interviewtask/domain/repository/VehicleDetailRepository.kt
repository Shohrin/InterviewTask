package com.example.interviewtask.domain.repository

import com.example.interviewtask.data.dto.VehicleDetailDto
import com.example.interviewtask.domain.model.VehicleDetailModel

interface VehicleDetailRepository {
    suspend fun fetchVehicleDetails() : List<VehicleDetailDto>
    suspend fun getVehicleById(id:Int) : VehicleDetailDto
}