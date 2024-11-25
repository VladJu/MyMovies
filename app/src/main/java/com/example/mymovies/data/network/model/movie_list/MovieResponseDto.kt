package com.example.mymovies.data.network.model.movie_list

import com.google.gson.annotations.SerializedName

data class MovieResponseDto(
    @SerializedName("docs")
    val movesList: List<MovieDto>?
)