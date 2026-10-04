package com.example.interviewtask.domain.usecase

import com.example.interviewtask.common.Resource
import com.example.interviewtask.data.dto.toVehicleModel
import com.example.interviewtask.domain.model.VehicleDetailModel
import com.example.interviewtask.domain.repository.VehicleDetailRepository
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class GetVehicleListUseCase @Inject constructor(private val vehicleDetailRepository: VehicleDetailRepository) {
    operator fun invoke() = flow {
        try {
            emit(Resource.Loading<List<VehicleDetailModel>>())
            val vehiclesList =
                vehicleDetailRepository.fetchVehicleDetails().map { it.toVehicleModel() }
            emit(Resource.Success<List<VehicleDetailModel>>(vehiclesList))
        } catch (e: HttpException) {
            emit(
                Resource.Error<List<VehicleDetailModel>>(
                    e.localizedMessage ?: "An unexpected error occured"
                )
            )
        } catch (e: IOException) {
            emit(Resource.Error<List<VehicleDetailModel>>("Couldn't reach server. Check your internet connection."))
        }
    }
}