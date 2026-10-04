package com.example.interviewtask.presentation.vehiclelist

import com.example.interviewtask.common.Resource
import com.example.interviewtask.domain.model.VehicleDetailModel
import com.example.interviewtask.domain.usecase.GetVehicleListUseCase
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class VehicleListViewModelTest {

    private val useCase: GetVehicleListUseCase = mockk()
    private val testDispatcher = UnconfinedTestDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `fetchVehicleList triggers on initialization and updates state with list on success`() =
        runTest {
            val fakeVehiclesList = listOf(
                VehicleDetailModel(
                    id = 1,
                    name = "Tesla Model S",
                    model = "Plaid",
                    status = "Active",
                    connectivityStatus = "ONLINE",
                    batteryPercent = 90,
                    currentSpeed = 0,
                    estimatedRange = 600,
                    odometer = 5000,
                    lastUpdateTime = "05:04 PM"
                )
            )

            every { useCase.invoke() } returns flowOf(Resource.Success(fakeVehiclesList))
            val viewModel = VehicleListViewModel(useCase)
           val currentState = viewModel.state.value

            assertFalse(currentState.isLoading) // Loading state flag must switch back to false
            assertEquals(
                fakeVehiclesList,
                currentState.vehicleList
            )
            assertEquals(
                "Tesla Model S",
                currentState.vehicleList.first().name
            )
        }
}
