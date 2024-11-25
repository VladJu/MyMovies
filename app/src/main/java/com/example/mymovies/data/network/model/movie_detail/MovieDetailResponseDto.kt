package com.example.mymovies.data.network.model.movie_detail

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class MovieDetailResponseDto(
    @SerializedName("videos")
    @Expose
    val movieTrailers: TrailerContainerDto?
)