package com.example.mymovies.presentation.movie_detail_ui

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.mymovies.R
import com.example.mymovies.databinding.FragmentMovieDetailBinding
import com.example.mymovies.domain.model.model_movie_list.MovieEntity
import com.example.mymovies.presentation.movie_detail_ui.adapter.review.ReviewAdapter
import com.example.mymovies.presentation.movie_detail_ui.adapter.trailer.TrailerAdapter
import kotlinx.coroutines.launch

class MovieDetailFragment : Fragment() {

    private lateinit var movie: MovieEntity

    private lateinit var viewModel: MovieDetailViewModel

    private lateinit var trailerAdapter: TrailerAdapter
    private lateinit var reviewAdapter: ReviewAdapter

    private var _binding: FragmentMovieDetailBinding? = null
    private val binding: FragmentMovieDetailBinding
        get() = _binding ?: throw RuntimeException("FragmentMovieDetailBinding is null")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseArgs()
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieDetailBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[MovieDetailViewModel::class.java]
        viewModel.loadDetailMovie(movie.id)
        viewModel.loadReviewMovie(movie.id)
        setupRecyclersView()
        setupOnClickListeners()
        viewModel.getFavouriteMovie(movie.id).observe(viewLifecycleOwner){
            if (it == null){
                binding.imageViewFavorite.setImageResource(R.drawable.heart_while)
                binding.imageViewFavorite.setOnClickListener {
                    viewModel.addFavouriteMovie(movie)
                }
            } else{
                binding.imageViewFavorite.setImageResource(R.drawable.heart_red)
                binding.imageViewFavorite.setOnClickListener {
                    viewModel.deleteFavouriteMovie(movie.id)

                }
            }
        }
        lifecycleScope.launch {
            viewModel.moviesDetail.collect {
                when (it) {
                    is StateDetail.Initial -> {

                    }

                    is StateDetail.Loading -> {

                    }

                    is StateDetail.Success -> {
                        trailerAdapter.submitList(it.currencyList)
                    }

                    is StateDetail.Error -> {
                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG)
                            .show()
                    }

                }
            }

        }
        lifecycleScope.launch {
            viewModel.moviesReview.collect {
                when (it) {
                    is StateReview.Initial -> {

                    }

                    is StateReview.Loading -> {

                    }

                    is StateReview.Success -> {
                        reviewAdapter.submitList(it.currencyList)
                    }

                    is StateReview.Error -> {
                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG)
                            .show()
                    }

                }
            }
        }
        bindViews()
    }

    private fun setupRecyclersView() {
        trailerAdapter = TrailerAdapter()
        reviewAdapter = ReviewAdapter()
        with(binding.movieInfo) {
            recyclerViewTrailers.adapter = trailerAdapter
            recyclerViewReview.adapter = reviewAdapter
        }
    }

    private fun setupOnClickListeners() {
        onTrailerClickListener()
    }

    private fun onTrailerClickListener() {
        trailerAdapter.onTrailerClickListener = { trailer ->
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(trailer.urlTrailer)
            startActivity(intent)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun parseArgs() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            requireArguments().getParcelable(KEY_MOVIE_DETAIL, MovieEntity::class.java)?.let {
                movie = it
            }
        } else {
            requireArguments().getParcelable<MovieEntity>(KEY_MOVIE_DETAIL)?.let {
                movie = it
            }
        }
    }

    private fun bindViews() {
        with(binding) {

            Glide.with(this@MovieDetailFragment)
                .load((movie.poster.url))
                .placeholder(R.drawable.progress_animation)
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .into(imageViewPosterBack)

            Glide.with(this@MovieDetailFragment)
                .load((movie.poster.url))
                .placeholder(R.drawable.progress_animation)
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .into(imageViewPosterMain)
        }
        with(binding.movieInfo) {
            val genres =
                movie.genres.joinToString(",") { Genres ->
                    Genres.name.replaceFirstChar {
                        it.uppercase()
                    }
                }
            textViewTitle.text = movie.name
            textViewGenres.text = genres
            textViewRating.text = movie.rating.kp.toString()
            textViewReleaseData.text = movie.year.toString()
            textViewDescription.text = movie.description
        }


    }


    companion object {

        private const val KEY_MOVIE_DETAIL = "key_movie_detail"

        fun newInstanceDetail(movie: MovieEntity): MovieDetailFragment {
            return MovieDetailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(KEY_MOVIE_DETAIL, movie)
                }
            }
        }
    }
}