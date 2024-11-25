package com.example.mymovies.domain.model.model_movie_list.model_secondary

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class VotesEntity(
    val kp: Int,
    val imdb: Int
) : Parcelable