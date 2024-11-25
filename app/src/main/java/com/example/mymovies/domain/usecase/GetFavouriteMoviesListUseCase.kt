package com.example.mymovies.domain.usecase

import com.example.mymovies.domain.MovieRepository

class GetFavouriteMoviesListUseCase (private val repository: MovieRepository) {
    operator fun invoke() = repository.getFavouriteMoviesList()
}