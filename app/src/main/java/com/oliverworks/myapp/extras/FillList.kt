package com.oliverworks.myapp.extras

import android.content.Context
import com.android.academy.fundamentals.homework.features.data.loadMovies
import com.oliverworks.myapp.data.classes.Movie

object FillList {
        suspend fun getMovies(context: Context): List<Movie> {
            return loadMovies(context = context)
        }
}