package com.example.hotelapplication.screens.room

import androidx.lifecycle.ViewModel
import com.example.domain.interactors.GetRoomUseCase
import com.example.domain.models.Room
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class RoomHotelViewModel @Inject constructor(private val getRoomUseCase: GetRoomUseCase) :
    ViewModel() {
    private val roomHotelMutable: MutableStateFlow<MutableList<Room>> =
        MutableStateFlow(mutableListOf())
    val roomHotelList: MutableStateFlow<MutableList<Room>> = roomHotelMutable

    suspend fun getRoomHotel() =
        withContext(Dispatchers.IO) {
            roomHotelMutable.value = getRoomUseCase.getRoom() as MutableList<Room>
        }
}