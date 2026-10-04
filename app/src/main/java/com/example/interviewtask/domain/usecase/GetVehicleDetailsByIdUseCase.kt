package com.example.interviewtask.domain.usecase

import com.example.interviewtask.common.Resource
import com.example.interviewtask.data.dto.toVehicleModel
import com.example.interviewtask.domain.model.VehicleDetailModel
import com.example.interviewtask.domain.repository.VehicleDetailRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetVehicleDetailsByIdUseCase @Inject constructor(private val repository: VehicleDetailRepository) {
    operator fun invoke(id: Int): Flow<Resource<VehicleDetailModel>> = flow {
        try {
            emit(Resource.Loading<VehicleDetailModel>())
            val vehicleDetailModel = repository.getVehicleById(id).toVehicleModel()
            emit(Resource.Success<VehicleDetailModel>(vehicleDetailModel))
        } catch (e: Exception) {
            emit(Resource.Error<VehicleDetailModel>("Unable to fetch the data at the movement"))
        }
    }
}