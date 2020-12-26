package com.oliverworks.myapp.extras

import android.content.Context
import com.android.academy.fundamentals.homework.features.data.Movie
import com.android.academy.fundamentals.homework.features.data.loadMovies

object FillList {
        suspend fun getMovies(context: Context): List<Movie> {
            return loadMovies(context = context)
        }
}