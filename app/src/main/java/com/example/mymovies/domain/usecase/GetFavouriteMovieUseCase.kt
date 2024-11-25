package com.example.mymovies.domain.usecase

import com.example.mymovies.domain.MovieRepository

class GetFavouriteMovieUseCase(private val repository: MovieRepository) {
     operator fun invoke(movieId: Int) = repository.getFavouriteMovie(movieId)
}