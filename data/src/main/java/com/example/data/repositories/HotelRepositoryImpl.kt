package com.example.data.repositories

import android.util.Log
import com.example.data.api.Api
import com.example.data.mappers.HotelMapper
import com.example.domain.models.Hotel
import com.example.domain.models.Order
import com.example.domain.models.Room
import com.example.domain.repositories.HotelRepository
import javax.inject.Inject

class HotelRepositoryImpl @Inject constructor(
    private val api: Api,
    private val mapper: HotelMapper
) : HotelRepository {
    override suspend fun getHotel(): Hotel {
        return api.getHotel().let {
            mapper.mapToDomainHotel(it)
        }
    }

    override suspend fun getOrder(): Order {
        return api.getOrder().let {
            mapper.mapToDomainOrder(it)
        }
    }

    override suspend fun getRoom(): List<Room> {
        var listNewRooms = listOf<Room>()
        api.getRoom().let {
                listNewRooms = it.rooms.map { roomDomain ->
                    mapper.mapToDomainRoom(roomDomain)
            }
        }
        Log.d("roomList", listNewRooms.toString())
        return listNewRooms
    }
}