package com.example.mymovies.data.database.model_db

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mymovies.data.database.model_db.model_db_secondary.CountriesDb
import com.example.mymovies.data.database.model_db.model_db_secondary.GenresDb
import com.example.mymovies.data.database.model_db.model_db_secondary.PosterDb
import com.example.mymovies.data.database.model_db.model_db_secondary.RatingDb
import com.example.mymovies.data.database.model_db.model_db_secondary.VotesDb

@Entity(tableName = "favourite_movies")
data class MovieDb(
    @PrimaryKey
    val id: Int,
    val name: String,
    val description: String,
    val year: Int,
    @Embedded
    val rating: RatingDb,
    @Embedded
    val votes: VotesDb,
    @Embedded
    val poster: PosterDb,
    val genres: List<GenresDb>,
    val countries: List<CountriesDb>,

    val movieLength: Int,
    val type: String,
    val typeNumber: Int,
    val shortDescription: String,
    val ageRating: Int
)