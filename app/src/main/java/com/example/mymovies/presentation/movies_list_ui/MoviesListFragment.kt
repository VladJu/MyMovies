package com.example.mymovies.presentation.movies_list_ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.mymovies.R
import com.example.mymovies.databinding.FragmentMoviesListBinding
import com.example.mymovies.presentation.movie_detail_ui.MovieDetailFragment
import com.example.mymovies.presentation.movie_favourite_ui.MoviesFavoriteFragment
import com.example.mymovies.presentation.movies_list_ui.adapter.MovieListAdapter
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MoviesListFragment : Fragment() {


    private var _binding: FragmentMoviesListBinding? = null
    private val binding: FragmentMoviesListBinding
        get() = _binding ?: throw RuntimeException("FragmentMoviesListBinding is null")

    private lateinit var moviesViewModel: MoviesViewModel

    private lateinit var movieListAdapter: MovieListAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMoviesListBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        moviesViewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().application)
        )[MoviesViewModel::class.java]
        setupRecyclerViewPosters()
        setupOnClickListeners()
        lifecycleScope.launch {
            moviesViewModel.moviesList.collect {
                when (it) {
                    is State.Initial -> {

                    }

                    is State.Loading -> {
                        binding.progressBarLoading.isVisible = true
                        delay(2000)
                    }

                    is State.Success -> {
                        binding.progressBarLoading.isGone = true
                        movieListAdapter.submitList(it.currencyList)
                    }

                    is State.Error -> {
                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG)
                            .show()
                    }

                }

            }
        }

    }

    private fun setupRecyclerViewPosters() {
        movieListAdapter = MovieListAdapter()
        binding.recyclerViewPosters.adapter = movieListAdapter
        with(binding.recyclerViewPosters) {
            recycledViewPool.setMaxRecycledViews(
                0,
                MovieListAdapter.MAX_POOL_MOVIE_LIST
            )
        }

    }

    private fun setupOnClickListeners() {
        onMovieClickListener()
        onMyFavouriteClickListener()
    }

    private fun onMyFavouriteClickListener() {
        binding.textViewMyFavourite.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.movies_list_container, MoviesFavoriteFragment.newInstance())
                .addToBackStack(null)
                .commit()
        }
    }

    private fun onMovieClickListener() {
        movieListAdapter.onMovieClickListener = { movie ->
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.movies_list_container, MovieDetailFragment.newInstanceDetail(movie))
                .addToBackStack(null)
                .commit()
        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("MoviesListActivity", "onDestroyViewFragment")
        _binding = null
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("MoviesListActivity", "onDetachFragment")
    }

    companion object {
        fun newInstance(): MoviesListFragment = MoviesListFragment()

    }
}