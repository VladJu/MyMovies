package com.example.mymovies.domain.model.model_movie_list.model_secondary

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GenresEntity(
     val name: String
) : Parcelable