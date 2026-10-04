package com.example.interviewtask.di

import com.example.interviewtask.common.Constants
import com.example.interviewtask.data.VehicleApiInterface
import com.example.interviewtask.data.repository.VehicleDetailRepositoryImpl
import com.example.interviewtask.domain.repository.VehicleDetailRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideVehicleApi(): VehicleApiInterface {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(VehicleApiInterface::class.java)
    }


    @Provides
    @Singleton
    fun provideVehicleRepository(api: VehicleApiInterface): VehicleDetailRepository {
        return VehicleDetailRepositoryImpl(api)
    }
}