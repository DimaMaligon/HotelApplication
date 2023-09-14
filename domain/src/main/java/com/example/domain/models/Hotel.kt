package com.example.domain.models

data class Hotel (
    var aboutTheHotel: AboutTheHotel,
    var adress: String,
    var id: Int,
    var imageUrls: List<String>,
    var minimalPrice: Int,
    var name: String,
    var priceForIt: String,
    var rating: Int,
    var ratingName: String
)

data class AboutTheHotel(
    var description: String,
    var peculiarities: List<String>
)