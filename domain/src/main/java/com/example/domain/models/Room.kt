package com.example.domain.models;

data class Room(
    var id: Int,
    var imageUrls: List<String>,
    var name: String,
    var peculiarities: List<String>,
    var price: Int,
    var pricePer: String
)

