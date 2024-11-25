package com.example.mymovies.data.database.model_db.model_db_secondary

import androidx.room.ColumnInfo


class VotesDb(
    @ColumnInfo(name="votesKp")
    val kp: Int,
    @ColumnInfo(name="votesImdb")
    val imdb: Int
)