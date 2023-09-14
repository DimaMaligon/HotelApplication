package com.example.data.modelsapi


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class OrderModel(
    @SerializedName("arrival_country")
    @Expose
    var arrivalCountry: String,
    @SerializedName("departure")
    @Expose
    var departure: String,
    @SerializedName("fuel_charge")
    @Expose
    var fuelCharge: Int,
    @SerializedName("horating")
    @Expose
    var horating: Int,
    @SerializedName("hotel_adress")
    @Expose
    var hotelAdress: String,
    @SerializedName("hotel_name")
    @Expose
    var hotelName: String,
    @SerializedName("id")
    @Expose
    var id: Int,
    @SerializedName("number_of_nights")
    @Expose
    var numberOfNights: Int,
    @SerializedName("nutrition")
    @Expose
    var nutrition: String,
    @SerializedName("rating_name")
    @Expose
    var ratingName: String,
    @SerializedName("room")
    @Expose
    var room: String,
    @SerializedName("service_charge")
    @Expose
    var serviceCharge: Int,
    @SerializedName("tour_date_start")
    @Expose
    var tourDateStart: String,
    @SerializedName("tour_date_stop")
    @Expose
    var tourDateStop: String,
    @SerializedName("tour_price")
    @Expose
    var tourPrice: Int
)