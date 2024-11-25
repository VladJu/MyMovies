package com.example.mymovies.data.network.model.movie_list

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class MovieDto(
    @SerializedName("id")
    @Expose
    val id: Int?,

    @SerializedName("name")
    @Expose
    val name: String?,

    @SerializedName("description")
    @Expose
    val description: String?,

    @SerializedName("year")
    @Expose
    val year: Int?,

    @SerializedName("rating")
    @Expose
    val rating: RatingDto?,

    @SerializedName("votes")
    @Expose
    val votesDto: VotesDto?,

    @SerializedName("poster")
    @Expose
    val poster: PosterDto?,

    @SerializedName("genres")
    @Expose
    val genres: List<GenresDto>?,

    @SerializedName("countries")
    @Expose
    val countries: List<CountriesDto>?,


    @SerializedName("movieLength")
    @Expose
    val movieLength: Int?,


    @SerializedName("type")
    @Expose
    val type: String? ,

    @SerializedName("typeNumber")
    @Expose
    val typeNumber: Int?,


    @SerializedName("shortDescription")
    @Expose
    val shortDescription: String?,

    @SerializedName("ageRating")
    @Expose
    val ageRating: Int?
)