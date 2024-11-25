package com.example.mymovies.presentation.movie_detail_ui.adapter.review

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.mymovies.databinding.ItemReviewBinding
import com.example.mymovies.domain.model.model_movie_detail.ReviewEntity

class ReviewAdapter : ListAdapter<ReviewEntity, ReviewViewHolder>(ReviewDiffCallback) {

    var onReviewClickListener: ((ReviewEntity) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        val binding = ItemReviewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ReviewViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        val review = getItem(position)
        with(holder.binding) {
            textViewAuthor.text = review.author
            textViewData.text = review.date
            textViewReview.text = review.review
        }
    }
}