package com.example.mymovies.domain.usecase

import com.example.mymovies.domain.MovieRepository
import com.example.mymovies.domain.model.model_movie_list.MovieEntity

class AddFavouriteMovieUseCase(private val repository: MovieRepository) {
    suspend operator fun invoke(movie: MovieEntity) = repository.addFavouriteMovie(movie)
}