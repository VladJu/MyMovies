package com.example.mymovies.domain.model.model_movie_list.model_secondary

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PosterEntity(
    val url: String,
    val previewUrl: String
) : Parcelable
