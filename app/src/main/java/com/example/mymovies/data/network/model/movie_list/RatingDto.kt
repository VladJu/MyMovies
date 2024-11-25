package com.example.mymovies.data.network.model.movie_list

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RatingDto(
    @SerializedName("kp")
    @Expose
    val kp: Double?,

    @SerializedName("imdb")
    @Expose
    val imdb: Double?,

    )

