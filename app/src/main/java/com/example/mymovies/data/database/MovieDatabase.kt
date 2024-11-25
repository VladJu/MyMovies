package com.example.mymovies.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.mymovies.data.database.converters.Converters
import com.example.mymovies.data.database.model_db.MovieDb
import com.google.gson.Gson


@Database(entities = [MovieDb::class], version = 1, exportSchema = false)
@TypeConverters(value = [Converters::class])
abstract class MovieDatabase : RoomDatabase() {

    abstract fun movieFavouriteDao() : MovieFavouriteDao


    companion object {
        private val gson=Gson()
        private var db: MovieDatabase? = null
        private const val DB_NAME = "movie_db"
        private val LOCK = Any()

        fun getInstance(context: Context): MovieDatabase {

            synchronized(LOCK) {
                db?.let {
                    return it
                }

                val instance = Room.databaseBuilder(
                    context,
                    MovieDatabase::class.java,
                    DB_NAME
                ).apply {
                    addTypeConverter(Converters(gson))
                }
                    .build()

                db = instance
                return instance

            }
        }

    }
}