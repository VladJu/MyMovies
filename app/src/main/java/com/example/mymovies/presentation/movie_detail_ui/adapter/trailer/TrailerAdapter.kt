package com.example.mymovies.presentation.movie_detail_ui.adapter.trailer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.mymovies.databinding.ItemTrailerBinding
import com.example.mymovies.domain.model.model_movie_detail.TrailerEntity

class TrailerAdapter : ListAdapter<TrailerEntity, TrailerViewHolder>(TrailerDiffCallback) {

    var onTrailerClickListener : ((TrailerEntity) -> Unit)? =null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrailerViewHolder {
        val binding = ItemTrailerBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TrailerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TrailerViewHolder, position: Int) {
        val trailer=getItem(position)
        with(holder.binding){
            textViewTrailerName.text=trailer.name
            imageViewPlay.setOnClickListener {
                onTrailerClickListener?.invoke(trailer)
            }
        }
    }


}