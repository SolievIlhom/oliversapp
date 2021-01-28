package com.oliverworks.myapp.data.pojo.movie

import com.google.gson.annotations.SerializedName
import com.oliverworks.movieapphomeworktest.pojo.movie.Movie

class Result (
    @SerializedName("dates")
    var dates: Dates? = null,

    @SerializedName("page")
    var page: Int? = null,

    @SerializedName("results")
    var results: List<Movie>? = null,
)