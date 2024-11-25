package com.example.mymovies.data.network.model.movie_detail

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ReviewDto(

    @SerializedName("movieId")
    @Expose
    val movieId: Int?,

    @SerializedName("type")
    @Expose
    val type: String?,
    @SerializedName("review")
    @Expose
    val review: String?,

    @SerializedName("date")
    @Expose
    val date: String?,

    @SerializedName("author")
    @Expose
    val author: String?
)
