package com.example.interviewtask.data.repository

import com.example.interviewtask.data.VehicleApiInterface
import com.example.interviewtask.data.dto.VehicleDetailDto
import com.example.interviewtask.domain.repository.VehicleDetailRepository
import javax.inject.Inject

class VehicleDetailRepositoryImpl @Inject constructor(private val apiInterface: VehicleApiInterface) :
    VehicleDetailRepository {
    private var cachedVehicles = emptyList<VehicleDetailDto>()
    override suspend fun fetchVehicleDetails(): List<VehicleDetailDto> {
        cachedVehicles = apiInterface.fetchVehicleDetails()
        return cachedVehicles
    }

    override suspend fun getVehicleById(id: Int): VehicleDetailDto {
        return cachedVehicles.find { it.id == id }!!
    }
}