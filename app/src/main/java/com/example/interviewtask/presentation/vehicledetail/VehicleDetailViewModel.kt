package com.example.interviewtask.presentation.vehicledetail

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.interviewtask.common.Resource
import com.example.interviewtask.domain.usecase.GetVehicleDetailsByIdUseCase
import com.example.interviewtask.presentation.navigation.VehicleDetailRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

import androidx.navigation.toRoute
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.launchIn

@HiltViewModel
class VehicleDetailViewModel @Inject constructor(
    private val useCase: GetVehicleDetailsByIdUseCase,
    savedStateHandle: SavedStateHandle
) :
    ViewModel() {
    private val _state = mutableStateOf(VehicleDetailState())
    val state = _state
    private val routeArgs = savedStateHandle.toRoute<VehicleDetailRoute>()
    val vehicleId: Int = routeArgs.vehicleId

    init {
        Log.e("Shohrin", " vehicle ID $vehicleId")
        getVehicleById()
    }

    fun getVehicleById() {
        useCase(vehicleId).onEach { result ->
            when (result) {
                is Resource.Error<*> -> {
                    _state.value =
                        VehicleDetailState(result.message ?: "An unexpected error occured")
                }

                is Resource.Loading<*> -> {
                    _state.value = VehicleDetailState(isLoading = true)
                }

                is Resource.Success<*> -> {
                    _state.value = VehicleDetailState(data = result.data)
                }
            }
        }.launchIn(viewModelScope)
    }
}