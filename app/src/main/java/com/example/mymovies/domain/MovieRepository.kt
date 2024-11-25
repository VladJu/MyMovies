package com.example.mymovies.domain

import androidx.lifecycle.LiveData
import com.example.mymovies.domain.model.model_movie_detail.ReviewEntity
import com.example.mymovies.domain.model.model_movie_detail.TrailerEntity
import com.example.mymovies.domain.model.model_movie_list.MovieEntity

interface MovieRepository {

    suspend fun loadMovies(): List<MovieEntity>

    suspend fun loadMovieDetailInfo(movieId: Int): List<TrailerEntity>

    suspend fun loadReviewsMovie(movieId: Int): List<ReviewEntity>

    fun getFavouriteMovie(movieId: Int): LiveData<MovieEntity>

    suspend fun addFavouriteMovie(movie: MovieEntity)

    fun getFavouriteMoviesList(): LiveData<List<MovieEntity>>

    suspend fun deleteFavoriteMovie(movieId: Int)


}