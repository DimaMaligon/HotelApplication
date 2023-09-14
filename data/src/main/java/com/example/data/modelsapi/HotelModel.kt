package com.example.data.modelsapi


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class HotelModel(
    @SerializedName("about_the_hotel")
    @Expose
    var aboutTheHotel: AboutTheHotel,
    @SerializedName("adress")
    @Expose
    var adress: String,
    @SerializedName("id")
    @Expose
    var id: Int,
    @SerializedName("image_urls")
    @Expose
    var imageUrls: List<String>,
    @SerializedName("minimal_price")
    @Expose
    var minimalPrice: Int,
    @SerializedName("name")
    @Expose
    var name: String,
    @SerializedName("price_for_it")
    @Expose
    var priceForIt: String,
    @SerializedName("rating")
    @Expose
    var rating: Int,
    @SerializedName("rating_name")
    @Expose
    var ratingName: String
)

data class AboutTheHotel(
    @SerializedName("description")
    @Expose
    var description: String,
    @SerializedName("peculiarities")
    @Expose
    var peculiarities: List<String>
)