package ru.petrgostev.myfirstproject.data.jsоn

import android.content.Context
import com.android.academy.fundamentals.homework.features.data.loadMovies
import com.oliverworks.myapp.data.classes.Movie

class MoviesGet(private val context: Context) : MoviesGetOutput {
    override suspend fun invoke(): List<Movie> = loadMovies(context)
}