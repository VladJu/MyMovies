package com.example.mymovies.presentation.movie_favourite_ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mymovies.databinding.FragmentFavouriteMoviesBinding
import com.example.mymovies.presentation.movies_list_ui.MoviesListFragment
import com.example.mymovies.presentation.movies_list_ui.adapter.MovieListAdapter

class MoviesFavoriteFragment : Fragment() {


    private lateinit var viewModel: MoviesFavouriteViewModel

    private lateinit var movieAdapter :MovieListAdapter

    private var _binding: FragmentFavouriteMoviesBinding?=null
    val binding : FragmentFavouriteMoviesBinding
        get() = _binding ?: throw RuntimeException("MoviesFavoriteFragment is null")


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding=FragmentFavouriteMoviesBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel=ViewModelProvider(this)[MoviesFavouriteViewModel::class.java]
        setupRecyclersView()
        viewModel.favouriteMovies().observe(viewLifecycleOwner){
            movieAdapter.submitList(it)
        }
    }



    private fun setupRecyclersView() {
        movieAdapter= MovieListAdapter()
        with(binding) {
            recyclerViewFavouriteMovies.adapter=movieAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

    companion object {
        fun newInstance(): MoviesFavoriteFragment = MoviesFavoriteFragment()

    }
}