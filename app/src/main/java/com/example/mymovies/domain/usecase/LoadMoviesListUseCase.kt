package com.example.mymovies.domain.usecase

import com.example.mymovies.domain.MovieRepository

class LoadMoviesListUseCase(private val repository: MovieRepository) {
    suspend operator fun invoke() = repository.loadMovies()
}