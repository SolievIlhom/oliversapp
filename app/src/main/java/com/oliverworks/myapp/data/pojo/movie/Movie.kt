package com.oliverworks.movieapphomeworktest.pojo.movie

import com.google.gson.annotations.SerializedName

class Movie (
    @SerializedName("adult")
    var adult: Boolean = false,

    @SerializedName("backdrop_path")
    var backdropPath: String = "",

    @SerializedName("genre_ids")
    var genreIds: List<Int> = emptyList(),
    @SerializedName("id")
    var id: Int = 0,


    @SerializedName("overview")
    var overview: String = "",

    @SerializedName("popularity")
    var popularity: Double = 0.0,

    @SerializedName("poster_path")
    var posterPath: String = "",

    @SerializedName("release_date")
    var releaseDate: String = "",

    @SerializedName("title")
    var title: String = "",



    @SerializedName("vote_average")
    var voteAverage: Double = 0.0,

    @SerializedName("vote_count")
    var voteCount: Int = 0
){
    fun getImageSizePoster500() = "https://image.tmdb.org/t/p/w500${this.posterPath}"
    fun getImageSizeBackdrop500() = "https://image.tmdb.org/t/p/w500${this.backdropPath}"
    fun getImageSizeBackdrop300() = "https://image.tmdb.org/t/p/w300${this.backdropPath}"
    fun getImageSizePoster300() = "https://image.tmdb.org/t/p/w300${this.posterPath}"
    fun getImageSize185() = "https://image.tmdb.org/t/p/w185${this.backdropPath}"

}