package com.oliverworks.myapp

import com.oliverworks.myapp.data.classes.Movie

interface Router {
    fun openMoviesDetailsFragment(movie: Movie)
}