package com.example.mymovies.presentation.movie_detail_ui.adapter.review

import androidx.recyclerview.widget.DiffUtil
import com.example.mymovies.domain.model.model_movie_detail.ReviewEntity

object ReviewDiffCallback : DiffUtil.ItemCallback<ReviewEntity>() {

    override fun areItemsTheSame(oldItem: ReviewEntity, newItem: ReviewEntity): Boolean {
        return oldItem.movieId == newItem.movieId
    }

    override fun areContentsTheSame(oldItem: ReviewEntity, newItem: ReviewEntity): Boolean {
        return oldItem == newItem
    }
}