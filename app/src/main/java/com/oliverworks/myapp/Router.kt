package com.oliverworks.myapp

import com.oliverworks.myapp.data.pojo.moviesDetails.MovieDetails

interface Router {
    fun openMoviesDetailsFragment(movie: MovieDetails)
}