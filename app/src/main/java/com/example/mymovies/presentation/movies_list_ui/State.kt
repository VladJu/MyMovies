package com.example.mymovies.presentation.movies_list_ui

import com.example.mymovies.domain.model.model_movie_list.MovieEntity

sealed class State {
    object Initial : State()
    object Loading : State()
    data class Success(val currencyList: List<MovieEntity>) : State()
    data class Error(val message: String) : State()
}


