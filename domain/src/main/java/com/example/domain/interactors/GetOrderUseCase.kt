package com.example.domain.interactors

import com.example.domain.models.Hotel
import com.example.domain.models.Order
import com.example.domain.repositories.HotelRepository

class GetOrderUseCase constructor(private val repository: HotelRepository) {
    suspend fun getOrder(): Order {
        return repository.getOrder()
    }
}