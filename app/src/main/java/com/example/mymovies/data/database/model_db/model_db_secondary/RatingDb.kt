package com.example.mymovies.data.database.model_db.model_db_secondary

import androidx.room.ColumnInfo


data class RatingDb(
    @ColumnInfo(name="ratingKp")
    val kp: Double,
    @ColumnInfo(name="ratingImdb")
    val imdb: Double,
    )

