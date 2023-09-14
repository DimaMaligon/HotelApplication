package com.example.data.di.model

import com.example.data.api.ApiManager
import com.example.data.mappers.HotelMapper
import com.example.data.repositories.HotelRepositoryImpl
import com.example.domain.repositories.HotelRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {
    @Provides
    @Singleton
    fun provideApiManager(): ApiManager {
        return ApiManager()
    }

    @Provides
    fun provideMapper(): HotelMapper {
        return HotelMapper()
    }

    @Provides
    fun provideHotelRepositories(apiManager: ApiManager, mapperHotel: HotelMapper): HotelRepository =
        HotelRepositoryImpl(apiManager.getApi(), mapperHotel)
}