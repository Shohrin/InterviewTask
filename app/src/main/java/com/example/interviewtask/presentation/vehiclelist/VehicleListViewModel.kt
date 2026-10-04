package com.example.interviewtask.presentation.vehiclelist

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.interviewtask.common.Resource
import com.example.interviewtask.domain.usecase.GetVehicleListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class VehicleListViewModel @Inject constructor(private val useCase: GetVehicleListUseCase) :
    ViewModel() {
    private val _state = mutableStateOf(VehicleListState())
    val state: State<VehicleListState> = _state

    init {
        fetchVehicleList()
    }

    private fun fetchVehicleList() {
        useCase().onEach {
            result ->
            when(result){
                is Resource.Loading ->
                {
                    _state.value = VehicleListState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = VehicleListState(vehicleList = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value =
                        VehicleListState(error = result.message ?: "An unexpected error occured")
                }

            }
        }.launchIn(viewModelScope)
    }
}