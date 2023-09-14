package com.example.domain.interactors

import com.example.domain.models.Hotel
import com.example.domain.repositories.HotelRepository

class GetHotelUseCase constructor(private val repository: HotelRepository) {
    suspend fun getHotel(): Hotel {
        return repository.getHotel()
    }
}