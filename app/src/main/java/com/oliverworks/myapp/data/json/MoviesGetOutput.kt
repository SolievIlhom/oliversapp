package ru.petrgostev.myfirstproject.data.jsоn

import com.oliverworks.myapp.data.classes.Movie

interface MoviesGetOutput {
    suspend operator fun invoke(): List<Movie>
}