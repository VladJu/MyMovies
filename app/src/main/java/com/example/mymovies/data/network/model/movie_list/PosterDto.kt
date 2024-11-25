package com.example.mymovies.data.network.model.movie_list

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PosterDto(
    @SerializedName("url")
    @Expose
    val url: String?,

    @SerializedName("previewUrl")
    @Expose
    val previewUrl: String?
)
