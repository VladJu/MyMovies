package com.example.mymovies.presentation.movies_list_ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.mymovies.domain.model.model_movie_list.MovieEntity

object MovieDiffCallback : DiffUtil.ItemCallback<MovieEntity>() {
    override fun areItemsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
        return oldItem == newItem
    }
}