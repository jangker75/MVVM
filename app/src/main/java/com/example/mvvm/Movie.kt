package com.example.mvvm


import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("id")
    var id: Int,
    @SerializedName("image")
    var image: String,
    @SerializedName("is_new")
    var isNew: Int,
    @SerializedName("language")
    var language: String,
    @SerializedName("like_percent")
    var likePercent: Int,
    @SerializedName("rating")
    var rating: String,
    @SerializedName("title")
    var title: String,
    @SerializedName("type")
    var type: String,
    @SerializedName("vote_count")
    var voteCount: Int
)