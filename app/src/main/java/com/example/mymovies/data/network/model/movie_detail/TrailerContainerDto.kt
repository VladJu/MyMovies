package com.example.mymovies.data.network.model.movie_detail

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TrailerContainerDto(
    @SerializedName("trailers")
    @Expose
    val trailers: List<TrailerDto>?
)