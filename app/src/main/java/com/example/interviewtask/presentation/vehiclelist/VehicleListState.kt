package com.example.interviewtask.presentation.vehiclelist

import com.example.interviewtask.domain.model.VehicleDetailModel

data class VehicleListState(
    public val isLoading: Boolean = false,
    public val error: String = "",
    public val vehicleList: List<VehicleDetailModel> = emptyList()
)