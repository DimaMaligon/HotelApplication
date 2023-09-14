package com.example.data.api

import com.example.data.modelsapi.HotelModel
import com.example.data.modelsapi.OrderModel
import com.example.data.modelsapi.RoomModel
import retrofit2.http.GET

interface Api {
    @GET("35e0d18e-2521-4f1b-a575-f0fe366f66e3")
    suspend fun getHotel(): HotelModel

    @GET("f9a38183-6f95-43aa-853a-9c83cbb05ecd")
    suspend fun getRoom(): RoomModel

    @GET("e8868481-743f-4eb2-a0d7-2bc4012275c8")
    suspend fun getOrder(): OrderModel
}