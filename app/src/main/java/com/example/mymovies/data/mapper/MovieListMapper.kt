package com.example.mymovies.data.mapper


import com.example.mymovies.data.database.model_db.MovieDb
import com.example.mymovies.data.database.model_db.model_db_secondary.CountriesDb
import com.example.mymovies.data.database.model_db.model_db_secondary.GenresDb
import com.example.mymovies.data.database.model_db.model_db_secondary.PosterDb
import com.example.mymovies.data.database.model_db.model_db_secondary.RatingDb
import com.example.mymovies.data.database.model_db.model_db_secondary.VotesDb
import com.example.mymovies.data.network.model.movie_list.MovieDto
import com.example.mymovies.domain.model.model_movie_list.MovieEntity
import com.example.mymovies.domain.model.model_movie_list.model_secondary.CountriesEntity
import com.example.mymovies.domain.model.model_movie_list.model_secondary.GenresEntity
import com.example.mymovies.domain.model.model_movie_list.model_secondary.PosterEntity
import com.example.mymovies.domain.model.model_movie_list.model_secondary.RatingEntity
import com.example.mymovies.domain.model.model_movie_list.model_secondary.VotesEntity
import kotlin.math.roundToInt

class MovieListMapper {

    private fun mapMovieDtoToEntity(movieDto: MovieDto): MovieEntity {
        return MovieEntity(
            id = movieDto.id ?: 0,
            name = movieDto.name ?: "",
            description = movieDto.description ?: "",
            year = movieDto.year ?: 0,
            rating = mapMovieFieldsDtoToEntity(movieDto.rating) {
                RatingEntity(

                    kp = ((this?.kp?.times(10.0) ?: 0.0).roundToInt() / 10.0),
                    imdb = this?.imdb ?: 0.0
                )
            },
            votes = mapMovieFieldsDtoToEntity(movieDto.votesDto) {
                VotesEntity(

                    kp = this?.kp ?: 0,
                    imdb = this?.imdb ?: 0
                )
            },
            poster = mapMovieFieldsDtoToEntity(movieDto.poster) {
                PosterEntity(

                    url = this?.previewUrl ?: "",
                    previewUrl = this?.previewUrl ?: ""
                )
            },
            genres = mapMovieFieldsDtoToEntity(movieDto.genres) {
                this?.let {
                    map {
                        GenresEntity(

                            name = it.name ?: ""
                        )
                    }
                } ?: emptyList()
            },
            countries = mapMovieFieldsDtoToEntity(movieDto.countries) {
                this?.let {
                    map {
                        CountriesEntity(

                            name = it.name ?: ""
                        )
                    }
                } ?: emptyList()
            },
            movieLength = movieDto.movieLength ?: 0,
            type = movieDto.type ?: "",
            typeNumber = movieDto.typeNumber ?: 0,
            shortDescription = movieDto.shortDescription ?: "",
            ageRating = movieDto.ageRating ?: 0
        )

    }

    fun mapMovieDbToEntity(movieDb: MovieDb): MovieEntity {
        return MovieEntity(
            id = movieDb.id,
            name = movieDb.name,
            description = movieDb.description,
            year = movieDb.year,
            rating = mapMovieFieldsDbToEntity(movieDb.rating) {
                RatingEntity(

                    kp = ((this.kp.times(10.0)).roundToInt() / 10.0),
                    imdb = this.imdb
                )
            },
            votes = mapMovieFieldsDbToEntity(movieDb.votes) {
                VotesEntity(

                    kp = this.kp,
                    imdb = this.imdb
                )
            },
            poster = mapMovieFieldsDbToEntity(movieDb.poster) {
                PosterEntity(

                    url = this.previewUrl,
                    previewUrl = this.previewUrl
                )
            },
            genres = mapMovieFieldsDbToEntity(movieDb.genres) {
                map {
                    GenresEntity(

                        name = it.name
                    )
                }
            },
            countries = mapMovieFieldsDbToEntity(movieDb.countries) {
                map {
                    CountriesEntity(

                        name = it.name
                    )
                }
            },
            movieLength = movieDb.movieLength,
            type = movieDb.type,
            typeNumber = movieDb.typeNumber,
            shortDescription = movieDb.shortDescription,
            ageRating = movieDb.ageRating
        )

    }


    fun mapMovieEntityToDb(movieEntity: MovieEntity): MovieDb {
        return MovieDb(
            id = movieEntity.id,
            name = movieEntity.name,
            description = movieEntity.description,
            year = movieEntity.year,
            rating = mapMovieFieldsEntityToDb(movieEntity.rating) {
                RatingDb(

                    kp = ((this.kp.times(10.0)).roundToInt() / 10.0),
                    imdb = this.imdb
                )
            },
            votes = mapMovieFieldsEntityToDb(movieEntity.votes) {
                VotesDb(

                    kp = this.kp,
                    imdb = this.imdb
                )
            },
            poster = mapMovieFieldsEntityToDb(movieEntity.poster) {
                PosterDb(

                    url = this.previewUrl,
                    previewUrl = this.previewUrl
                )
            },
            genres = mapMovieFieldsEntityToDb(movieEntity.genres) {
                map {
                    GenresDb(

                        name = it.name
                    )
                }
            },
            countries = mapMovieFieldsEntityToDb(movieEntity.countries) {
                map {
                    CountriesDb(

                        name = it.name
                    )
                }
            },
            movieLength = movieEntity.movieLength,
            type = movieEntity.type,
            typeNumber = movieEntity.typeNumber,
            shortDescription = movieEntity.shortDescription,
            ageRating = movieEntity.ageRating
        )

    }


//For mapping from null to not-null
//    private fun <T, R> mapMovieFieldsDtoToEntity(obj: T?, operation: T.() -> R): R {
//        return obj?.operation() as R
//    }

    private fun <T, R> mapMovieFieldsDbToEntity(obj: T, operation: T.() -> R): R {
        return obj.operation()

    }

    private fun <T, R> mapMovieFieldsDtoToEntity(obj: T, operation: T.() -> R): R {
        return obj.operation()

    }

    private fun <T, R> mapMovieFieldsEntityToDb(obj: T, operation: T.() -> R): R {
        return obj.operation()

    }




    fun mapListMovieDtoToListEntity(listMovies: List<MovieDto>): List<MovieEntity> {
        return listMovies.map { mapMovieDtoToEntity(it) }
    }

    fun mapListMovieEntityToDb(listMovies: List<MovieEntity>): List<MovieDb> {
        return listMovies.map { mapMovieEntityToDb(it) }
    }

    fun mapListMovieDbToListEntity(listMovies: List<MovieDb>): List<MovieEntity> {
        return listMovies.map { mapMovieDbToEntity(it) }
    }
}