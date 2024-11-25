package com.example.mymovies.data.network.model.movie_list

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class VotesDto(
    @SerializedName("kp")
    @Expose
    val kp: Int?,

    @SerializedName("imdb")
    @Expose
    val imdb: Int?
)