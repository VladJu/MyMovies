package com.example.mymovies.data.network.model.movie_detail

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TrailerDto(
    @SerializedName("name")
    @Expose
    val name: String?,
    @SerializedName("url")
    @Expose
    val urlTrailer: String?

)