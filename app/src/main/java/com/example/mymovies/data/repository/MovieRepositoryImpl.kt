package com.example.mymovies.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.mymovies.data.database.MovieDatabase

import com.example.mymovies.data.mapper.MovieDetailMapper
import com.example.mymovies.data.mapper.MovieListMapper
import com.example.mymovies.data.network.ApiFactory
import com.example.mymovies.domain.MovieRepository
import com.example.mymovies.domain.model.model_movie_detail.ReviewEntity
import com.example.mymovies.domain.model.model_movie_detail.TrailerEntity
import com.example.mymovies.domain.model.model_movie_list.MovieEntity

class MovieRepositoryImpl(application: Application) : MovieRepository {

    private val apiService = ApiFactory.apiService
    private val movieFavouriteDao = MovieDatabase.getInstance(application).movieFavouriteDao()
    private val mapperList = MovieListMapper()
    private val mapperDetail = MovieDetailMapper()

    private var page: Int = 1

    override suspend fun loadMovies(): List<MovieEntity> {
        val movieListDto = apiService.loadMovies(page++).movesList ?: emptyList()
        return mapperList.mapListMovieDtoToListEntity(movieListDto)
    }


    override suspend fun loadMovieDetailInfo(movieId: Int): List<TrailerEntity> {
        val trailerListDto = apiService.loadTrailers(movieId).movieTrailers?.trailers ?: emptyList()
        return mapperDetail.mapTrailerListDtoToEntity(trailerListDto)
    }

    override suspend fun loadReviewsMovie(movieId: Int): List<ReviewEntity> {
        val reviewListDto = apiService.loadReviews(movieId).movieReview
        return mapperDetail.mapReviewListDtoToEntity(reviewListDto)
    }


    override  fun getFavouriteMovie(movieId: Int): LiveData<MovieEntity> {
        return Transformations.map( movieFavouriteDao.getFavouriteMovie(movieId)) {
            it?.let {  mapperList.mapMovieDbToEntity(it) }

        }
    }

    override suspend fun addFavouriteMovie(movie: MovieEntity) {
        movieFavouriteDao.addFavouriteMovie(mapperList.mapMovieEntityToDb(movie))
    }

    override fun getFavouriteMoviesList(): LiveData<List<MovieEntity>> {
        return Transformations.map(movieFavouriteDao.getFavouriteMoviesList()) {
            mapperList.mapListMovieDbToListEntity(it)
        }
    }

    override suspend fun deleteFavoriteMovie(movieId: Int) {
        movieFavouriteDao.deleteFavouriteMovie(movieId)
    }
}
