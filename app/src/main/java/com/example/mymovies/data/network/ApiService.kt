package com.example.mymovies.data.network

import com.example.mymovies.data.network.model.movie_detail.MovieDetailResponseDto
import com.example.mymovies.data.network.model.movie_detail.ReviewResponseDto
import com.example.mymovies.data.network.model.movie_list.MovieResponseDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET(
        "movie?token=$TOKEN" +
                "&limit=20" +
                "&sortField=votes.kp" +
                "&sortType=-1" +
                "&rating.kp=8-10"
    )
    suspend fun loadMovies(@Query(PAGE) page: Int): MovieResponseDto


    //loadDetailMovie

    @GET("movie/{$MOVIE_ID}?token=$TOKEN")
    suspend fun loadTrailers(@Path(MOVIE_ID) movieId: Int): MovieDetailResponseDto

    @GET("review?page=1&limit=6")
    suspend fun loadReviews(
        @Query(QUERY_PARAM_MOVIE_ID) movieId: Int,
        @Query(QUERY_PARAM_TOKEN) token : String = TOKEN
    ) : ReviewResponseDto


    companion object {

        private const val PAGE = "page"
        private const val TOKEN = "CMJH671-PB64269-H8GZ7GG-6HXQJAR"
        private const val QUERY_PARAM_TOKEN = "token"
        private const val QUERY_PARAM_MOVIE_ID = "movieId"

        private const val MOVIE_ID ="id"
    }

}