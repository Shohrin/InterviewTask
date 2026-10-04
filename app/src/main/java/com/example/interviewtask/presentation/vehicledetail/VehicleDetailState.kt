package com.example.interviewtask.presentation.vehicledetail

import com.example.interviewtask.common.Resource
import com.example.interviewtask.domain.model.VehicleDetailModel

data class VehicleDetailState(
    public val error: String = "",
    public val data: VehicleDetailModel? = null
,public val isLoading: Boolean = false
)