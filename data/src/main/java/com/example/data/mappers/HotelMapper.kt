package com.example.data.mappers

import com.example.data.modelsapi.AboutTheHotel
import com.example.data.modelsapi.HotelModel
import com.example.data.modelsapi.OrderModel
import com.example.data.modelsapi.RoomModelItem
import com.example.domain.models.Hotel
import com.example.domain.models.Order
import com.example.domain.models.Room

class HotelMapper {
    fun mapToDomainHotel(hotelModel: HotelModel): Hotel = with(hotelModel) {
        Hotel(
            aboutTheHotel = run {
                com.example.domain.models.AboutTheHotel(
                    description = aboutTheHotel.description,
                    peculiarities = aboutTheHotel.peculiarities
                )
            },
            adress = adress,
            id = id,
            imageUrls = imageUrls,
            minimalPrice = minimalPrice,
            name = name,
            priceForIt = priceForIt,
            rating = rating,
            ratingName = ratingName
        )
    }

    fun mapToEntityHotelModel(hotel: Hotel): HotelModel = with(hotel) {
        HotelModel(
            aboutTheHotel = run {
                AboutTheHotel(
                    description = aboutTheHotel.description,
                    peculiarities = aboutTheHotel.peculiarities
                )
            },
            adress = adress,
            id = id,
            imageUrls = imageUrls,
            minimalPrice = minimalPrice,
            name = name,
            priceForIt = priceForIt,
            rating = rating,
            ratingName = ratingName
        )
    }

    fun mapToEntityOrderModel(order: Order): OrderModel = with(order) {
        OrderModel(
            arrivalCountry,
            departure,
            fuelCharge,
            horating,
            hotelAdress,
            hotelName,
            id,
            numberOfNights,
            nutrition,
            ratingName,
            room,
            serviceCharge,
            tourDateStart,
            tourDateStop,
            tourPrice
        )
    }

    fun mapToDomainOrder(orderModel: OrderModel): Order = with(orderModel) {
        Order(
            arrivalCountry,
            departure,
            fuelCharge,
            horating,
            hotelAdress,
            hotelName,
            id,
            numberOfNights,
            nutrition,
            ratingName,
            room,
            serviceCharge,
            tourDateStart,
            tourDateStop,
            tourPrice
        )
    }

    fun mapToEntityRoom(roomParameters: Room): RoomModelItem = with(roomParameters) {
        RoomModelItem(
            id, imageUrls, name, peculiarities, price, pricePer
        )
    }

    fun mapToDomainRoom(room: RoomModelItem): Room = with(room) {
        Room(
            id, imageUrls, name, peculiarities, price, pricePer
        )
    }
}