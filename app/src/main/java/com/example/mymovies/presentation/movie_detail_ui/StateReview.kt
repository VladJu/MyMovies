package com.example.mymovies.presentation.movie_detail_ui

import com.example.mymovies.domain.model.model_movie_detail.ReviewEntity

sealed class StateReview {
    object Initial : StateReview()
    object Loading : StateReview()
    data class Success(val currencyList: List<ReviewEntity>) : StateReview()
    data class Error(val message: String) : StateReview()
}


