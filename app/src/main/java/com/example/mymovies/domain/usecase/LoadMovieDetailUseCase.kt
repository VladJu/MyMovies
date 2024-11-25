package com.example.mymovies.domain.usecase

import com.example.mymovies.domain.MovieRepository

class LoadMovieDetailUseCase (private val repository: MovieRepository) {
    suspend operator fun invoke(movieId:Int) = repository.loadMovieDetailInfo(movieId)
}