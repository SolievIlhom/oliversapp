package com.oliverworks.myapp.data.pojo.movie

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import com.oliverworks.movieapphomeworktest.pojo.movie.Movie

class Result {

    @SerializedName("dates")
    @Expose
    var dates: Dates? = null

    @SerializedName("page")
    @Expose
    var page: Int? = null

    @SerializedName("results")
    @Expose
    var results: List<Movie>? = null

    @SerializedName("total_pages")
    @Expose
    var totalPages: Int? = null

    @SerializedName("total_results")
    @Expose
    var totalResults: Int? = null
}