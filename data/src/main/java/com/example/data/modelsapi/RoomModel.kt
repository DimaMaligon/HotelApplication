package com.example.data.modelsapi;

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RoomModel(
    @SerializedName("rooms")
    @Expose
    var rooms: List<RoomModelItem>
)

data class RoomModelItem(
    @SerializedName("id")
    @Expose
    var id: Int,
    @SerializedName("image_urls")
    @Expose
    var imageUrls: List<String>,
    @SerializedName("name")
    @Expose
    var name: String,
    @SerializedName("peculiarities")
    @Expose
    var peculiarities: List<String>,
    @SerializedName("price")
    @Expose
    var price: Int,
    @SerializedName("price_per")
    @Expose
    var pricePer: String
)

