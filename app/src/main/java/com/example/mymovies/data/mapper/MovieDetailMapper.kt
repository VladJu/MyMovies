package com.example.mymovies.data.mapper

import com.example.mymovies.data.network.model.movie_detail.ReviewDto
import com.example.mymovies.data.network.model.movie_detail.TrailerDto
import com.example.mymovies.domain.model.model_movie_detail.ReviewEntity
import com.example.mymovies.domain.model.model_movie_detail.TrailerEntity

class MovieDetailMapper {


    private fun mapTrailerDtoToEntity(dto: TrailerDto): TrailerEntity {
        return TrailerEntity(
            name = dto.name ?: "",
            urlTrailer = dto.urlTrailer ?: "",
        )
    }

    private fun mapReviewDtoToEntity(dto: ReviewDto): ReviewEntity {
        return ReviewEntity(
            movieId = dto.movieId ?: 0,
            type = dto.type ?: "",
            review = dto.review ?: "",
            date = dto.date?.dropLast(5) ?: "",
            author = dto.author ?: ""
        )
    }


    fun mapTrailerListDtoToEntity(listDto: List<TrailerDto>): List<TrailerEntity> {
        return listDto.map { mapTrailerDtoToEntity(it) }
    }


    fun mapReviewListDtoToEntity(listDto: List<ReviewDto>): List<ReviewEntity> {
        return listDto.map { mapReviewDtoToEntity(it) }
    }
}