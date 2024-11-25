package com.example.mymovies.presentation.movie_detail_ui

import com.example.mymovies.domain.model.model_movie_detail.TrailerEntity

sealed class StateDetail {
    object Initial : StateDetail()
    object Loading : StateDetail()
    data class Success(val currencyList: List<TrailerEntity>) : StateDetail()
    data class Error(val message: String) : StateDetail()
}


