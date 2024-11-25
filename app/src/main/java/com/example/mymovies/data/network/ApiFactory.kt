package com.example.mymovies.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {


    private const val BASE_URL = "https://api.kinopoisk.dev/v1.4/"

        private val retrofit= Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()


        val apiService : ApiService = retrofit.create(ApiService::class.java)

}