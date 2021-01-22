package com.oliverworks.myapp.api


import com.oliverworks.movieapphomeworktest.pojo.movie.Movie
import com.oliverworks.myapp.data.pojo.actor.Actor
import com.oliverworks.myapp.data.pojo.movie.Result
import com.oliverworks.myapp.data.pojo.moviesDetails.MovieDetails
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("movie/now_playing")
    suspend fun getMovies(
        @Query("api_key") key: String =  api_key,
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1
    ): Result

    @GET("search/movie")
    suspend fun getMovieSearch(
        @Query("api_key") key: String =  api_key,
        @Query("query") query: String
    ): Movie

    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id") movie_id: Int?,
        @Query("api_key") key: String = api_key
    ): MovieDetails

    @GET("person/{person_id}")
    suspend fun getActors(
        @Path("person_id") person_id: Int,
        @Query("api_key") key: String = api_key
    ): Actor

    companion object {
        const val api_key = "77bf739b5b59bf63998c4eee06dd386b"
    }
}