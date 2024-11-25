package com.example.mymovies.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mymovies.data.database.model_db.MovieDb

@Dao
interface MovieFavouriteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFavouriteMovie(movie: MovieDb)

    @Query("DELETE FROM favourite_movies WHERE id=:movieId")
    suspend fun deleteFavouriteMovie(movieId: Int)

    @Query("SELECT * FROM favourite_movies WHERE id=:movieId LIMIT 1")
     fun getFavouriteMovie(movieId: Int): LiveData<MovieDb>

    @Query("SELECT * FROM favourite_movies ORDER BY id DESC")
    fun getFavouriteMoviesList(): LiveData<List<MovieDb>>
}