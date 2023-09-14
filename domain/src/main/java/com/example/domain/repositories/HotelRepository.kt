package com.example.domain.repositories

import com.example.domain.models.Hotel
import com.example.domain.models.Order
import com.example.domain.models.Room

interface HotelRepository {
    suspend fun getHotel(): Hotel

    suspend fun getOrder(): Order

    suspend fun getRoom(): List<Room>
}