package com.example.mymovies.presentation.movies_list_ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.mymovies.R
import com.example.mymovies.databinding.ItemMovieBinding
import com.example.mymovies.domain.model.model_movie_list.MovieEntity

class MovieListAdapter : ListAdapter<MovieEntity, MovieViewHolder>(MovieDiffCallback) {

    //var onReachEndListener: OnReachEndListener? = null

    var onMovieClickListener: ((MovieEntity) -> Unit)? = null
    var count = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        Log.d("MovieAdapterList", "onCreateViewHolder:${count++}")


        val binding = ItemMovieBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        Log.d("MovieAdapterList", "onBindViewHolder:${count++}")
        val movie = getItem(position)
        Glide.with(holder.itemView)
            .load((movie.poster.url))
            .placeholder(R.drawable.progress_animation)
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .into(holder.binding.imageViewPoster)

        val rating = movie.rating.kp

        val backgroundId = when (rating) {
            in 7.0..10.0 -> R.drawable.circle_green
            in 5.0..6.9 -> R.drawable.circle_yellow
            else -> R.drawable.circle_red
        }
        val background = ContextCompat.getDrawable(holder.itemView.context, backgroundId)

        holder.binding.textViewRating.background = background
        holder.binding.textViewRating.text = movie.rating.kp.toString()
        holder.binding.root.setOnClickListener {
            onMovieClickListener?.invoke(movie)
        }


//     pagination
//        if (position == currentList.size -1 && onReachEndListener !=null){
//            onReachEndListener?.onReachEnd()
//        }
    }
//
//    interface OnReachEndListener {
//
//        fun onReachEnd()
//    }


    companion object {
        const val VIEW_TYPE_MOVIE = 100
        const val MAX_POOL_MOVIE_LIST = 15
    }
}