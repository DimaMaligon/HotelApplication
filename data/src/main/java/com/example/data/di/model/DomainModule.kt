package com.example.data.di.model

import com.example.domain.interactors.GetHotelUseCase
import com.example.domain.interactors.GetOrderUseCase
import com.example.domain.interactors.GetRoomUseCase
import com.example.domain.repositories.HotelRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {
    @Provides
    fun providesGetHotelUseCase(repository: HotelRepository): GetHotelUseCase {
        return GetHotelUseCase(repository)
    }

    @Provides
    fun providesGetOrderUseCase(repository: HotelRepository): GetOrderUseCase {
        return GetOrderUseCase(repository)
    }

    @Provides
    fun providesGetRoomUseCase(repository: HotelRepository): GetRoomUseCase {
        return GetRoomUseCase(repository)
    }
}