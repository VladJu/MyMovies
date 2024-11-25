package com.example.mymovies.domain.model.model_movie_detail

data class ReviewEntity(

    val movieId: Int,
    val type: String,
    val review: String,
    val date: String,
    val author: String
)
