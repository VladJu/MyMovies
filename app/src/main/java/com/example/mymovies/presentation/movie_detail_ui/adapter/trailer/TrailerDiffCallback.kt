package com.example.mymovies.presentation.movie_detail_ui.adapter.trailer

import androidx.recyclerview.widget.DiffUtil
import com.example.mymovies.domain.model.model_movie_detail.TrailerEntity
import com.example.mymovies.domain.model.model_movie_list.MovieEntity

object TrailerDiffCallback : DiffUtil.ItemCallback<TrailerEntity>() {
    override fun areItemsTheSame(oldItem: TrailerEntity, newItem: TrailerEntity): Boolean {
        return oldItem.name==newItem.name
    }

    override fun areContentsTheSame(oldItem: TrailerEntity, newItem: TrailerEntity): Boolean {
        return oldItem == newItem
    }
}