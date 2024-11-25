package com.example.mymovies.presentation.movie_detail_ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel

import androidx.lifecycle.viewModelScope
import com.example.mymovies.data.repository.MovieRepositoryImpl
import com.example.mymovies.domain.model.model_movie_list.MovieEntity
import com.example.mymovies.domain.usecase.AddFavouriteMovieUseCase
import com.example.mymovies.domain.usecase.DeleteFavouriteMovieUseCase
import com.example.mymovies.domain.usecase.GetFavouriteMovieUseCase
import com.example.mymovies.domain.usecase.LoadMovieDetailUseCase
import com.example.mymovies.domain.usecase.LoadReviewsListUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MovieDetailViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = MovieRepositoryImpl(application)

    private val loadMovieDetailUseCase = LoadMovieDetailUseCase(repository)
    private val loadReviewsListUseCase = LoadReviewsListUseCase(repository)
    private val addFavouriteMovieUseCase = AddFavouriteMovieUseCase(repository)
    private val getFavouriteMovieUseCase = GetFavouriteMovieUseCase(repository)
    private val deleteFavouriteMovieUseCase = DeleteFavouriteMovieUseCase(repository)


    private val _moviesDetail = MutableStateFlow<StateDetail>(StateDetail.Initial)
    val moviesDetail = _moviesDetail.asStateFlow()

    private val _moviesReview = MutableStateFlow<StateReview>(StateReview.Initial)
    val moviesReview = _moviesReview.asStateFlow()

    fun getFavouriteMovie(movieId: Int) = getFavouriteMovieUseCase(movieId)


    fun loadDetailMovie(movieId: Int) {
        viewModelScope.launch {
            val moviesDetail = loadMovieDetailUseCase(movieId)
            _moviesDetail.value = StateDetail.Success(moviesDetail)
        }
    }

    fun loadReviewMovie(movieId: Int) {
        viewModelScope.launch {
            _moviesReview.value = StateReview.Success(loadReviewsListUseCase(movieId))
        }
    }

    fun deleteFavouriteMovie(movieId: Int) {
        viewModelScope.launch {
            deleteFavouriteMovieUseCase(movieId)
        }

    }

    fun addFavouriteMovie(movie: MovieEntity) {
        viewModelScope.launch {
            addFavouriteMovieUseCase(movie)
        }

    }

}