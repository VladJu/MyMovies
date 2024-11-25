package com.example.mymovies.presentation.movie_favourite_ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.mymovies.data.repository.MovieRepositoryImpl
import com.example.mymovies.domain.usecase.GetFavouriteMoviesListUseCase

class MoviesFavouriteViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = MovieRepositoryImpl(application)

    private val getFavouriteMoviesListUseCase=GetFavouriteMoviesListUseCase(repository)

    fun favouriteMovies() = getFavouriteMoviesListUseCase()

}