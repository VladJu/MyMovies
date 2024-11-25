package com.example.mymovies.domain.model.model_movie_list

import android.os.Parcelable
import com.example.mymovies.domain.model.model_movie_list.model_secondary.CountriesEntity
import com.example.mymovies.domain.model.model_movie_list.model_secondary.GenresEntity
import com.example.mymovies.domain.model.model_movie_list.model_secondary.PosterEntity
import com.example.mymovies.domain.model.model_movie_list.model_secondary.RatingEntity
import com.example.mymovies.domain.model.model_movie_list.model_secondary.VotesEntity
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieEntity(
    val id: Int,
    val name: String,
    val description: String,
    val year: Int,
    val rating: RatingEntity,
    val votes: VotesEntity,
    val poster: PosterEntity,
    val genres: List<GenresEntity>,
    val countries: List<CountriesEntity>,

    val movieLength: Int,
    val type: String,
    val typeNumber: Int,
    val shortDescription: String,
    val ageRating: Int

) : Parcelable