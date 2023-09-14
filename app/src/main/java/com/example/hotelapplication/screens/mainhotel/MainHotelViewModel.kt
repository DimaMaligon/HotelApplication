package com.example.hotelapplication.screens.mainhotel

import androidx.lifecycle.ViewModel
import com.example.domain.interactors.GetHotelUseCase
import com.example.domain.models.Hotel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainHotelViewModel @Inject constructor(private val getHotelUseCase: GetHotelUseCase): ViewModel() {
    private val hotelMutable: MutableStateFlow<MutableList<Hotel>> =
        MutableStateFlow(mutableListOf())
    val hotelList: MutableStateFlow<MutableList<Hotel>> = hotelMutable

    suspend fun getHotel() =
        withContext(Dispatchers.IO) {
            hotelMutable.value = mutableListOf(getHotelUseCase.getHotel())
        }
}