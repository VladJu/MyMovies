package com.example.mymovies.data.database.converters

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.mymovies.data.database.model_db.model_db_secondary.CountriesDb
import com.example.mymovies.data.database.model_db.model_db_secondary.GenresDb
import com.google.gson.Gson


@ProvidedTypeConverter
class Converters(
    private val gson: Gson
) {

    @TypeConverter
    fun fromGenresList(list: List<GenresDb>): String {
        return gson.toJson(list)
    }


    @TypeConverter
    fun toGenresList(name: String): List<GenresDb> {
        return gson.fromJson(name, Array<GenresDb>::class.java).toList()
    }


    @TypeConverter
    fun fromCountriesList(list: List<CountriesDb>): String {
        return gson.toJson(list)
    }


    @TypeConverter
    fun toCountriesList(name: String): List<CountriesDb> {
        return gson.fromJson(name, Array<CountriesDb>::class.java).toList()
    }
}