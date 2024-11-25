package com.example.mymovies.presentation.movies_list_ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mymovies.data.repository.MovieRepositoryImpl
import com.example.mymovies.domain.usecase.LoadMoviesListUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class MoviesViewModel(application:Application) : AndroidViewModel(application) {

    private val repository = MovieRepositoryImpl(application)

    private val loadMoviesListUseCase = LoadMoviesListUseCase(repository)


    private val _moviesList = MutableStateFlow<State>(State.Initial)
    val moviesList = _moviesList.asStateFlow()
        .onStart { emit(State.Loading) }

    init {
        loadMovies()
    }

    private fun loadMovies() {
        viewModelScope.launch {
            val moviesList = loadMoviesListUseCase()
            _moviesList.value = State.Success(moviesList)
        }

    }

}