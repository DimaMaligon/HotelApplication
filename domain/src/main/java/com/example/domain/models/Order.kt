package com.example.domain.models

data class Order(
    var arrivalCountry: String,
    var departure: String,
    var fuelCharge: Int,
    var horating: Int,
    var hotelAdress: String,
    var hotelName: String,
    var id: Int,
    var numberOfNights: Int,
    var nutrition: String,
    var ratingName: String,
    var room: String,
    var serviceCharge: Int,
    var tourDateStart: String,
    var tourDateStop: String,
    var tourPrice: Int
)