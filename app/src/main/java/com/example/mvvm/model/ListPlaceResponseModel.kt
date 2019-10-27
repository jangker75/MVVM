package com.example.mvvm.model


import com.google.gson.annotations.SerializedName

data class ListPlaceResponseModel(
    @SerializedName("data")
    var `data`: MutableList<PlaceModel>,
    @SerializedName("status_code")
    var statusCode: Int
) {
    data class PlaceModel(
        @SerializedName("image")
        var image: String,
        @SerializedName("location")
        var location: String,
        @SerializedName("name")
        var name: String
    )
}