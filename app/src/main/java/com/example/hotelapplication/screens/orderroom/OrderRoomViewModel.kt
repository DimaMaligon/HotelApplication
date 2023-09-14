package com.example.hotelapplication.screens.orderroom

import androidx.lifecycle.ViewModel
import com.example.domain.interactors.GetOrderUseCase
import com.example.domain.models.Order
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class OrderRoomViewModel @Inject constructor(private val getOrderUseCase: GetOrderUseCase) :
    ViewModel() {
    private val orderRoomMutable: MutableStateFlow<MutableList<Order>> =
        MutableStateFlow(mutableListOf())
    val orderRoom: MutableStateFlow<MutableList<Order>> = orderRoomMutable
    private val orderCountTouristMutable: MutableStateFlow<Int> =
        MutableStateFlow(0)
    val orderCountTourist: MutableStateFlow<Int> = orderCountTouristMutable
    private val listTouristMutable: MutableStateFlow<MutableList<String>> =
        MutableStateFlow(mutableListOf())
    val listTourist: MutableStateFlow<MutableList<String>> = listTouristMutable

    suspend fun getOrder() =
        withContext(Dispatchers.IO) {
            orderRoomMutable.value = mutableListOf(getOrderUseCase.getOrder())
        }

    fun setTouristList(list: MutableList<String>) {
        listTouristMutable.value = list
    }

    fun setTouristCount(count: Int) {
        orderCountTourist.value = count
    }


}