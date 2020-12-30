package com.oliverworks.myapp.moviesList.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.petrgostev.myfirstproject.data.jsоn.MoviesGet

class ViewModelFactoryMoviesList(private val moviesGetOutput: MoviesGet) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T = when (modelClass) {
        ViewModelListMovies::class.java -> ViewModelListMovies(moviesGetOutput)
        else -> throw IllegalArgumentException("$modelClass is not registered ViewModel")
    } as T
}