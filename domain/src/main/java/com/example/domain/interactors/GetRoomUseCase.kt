package com.example.domain.interactors

import com.example.domain.models.Room
import com.example.domain.repositories.HotelRepository

class GetRoomUseCase constructor(private val repository: HotelRepository) {
    suspend fun getRoom(): List<Room> {
        return repository.getRoom()
    }
}