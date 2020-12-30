package com.oliverworks.myapp.moviesList.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oliverworks.myapp.data.classes.Movie
import kotlinx.coroutines.launch
import ru.petrgostev.myfirstproject.data.jsоn.MoviesGetOutput

class ViewModelListMovies(private val generator: MoviesGetOutput) : ViewModel() {

    private val _mutableMoviesList = MutableLiveData<List<Movie>>(emptyList())

    val moviesList: LiveData<List<Movie>> get() = _mutableMoviesList

    fun loadMovies() {
        viewModelScope.launch {
            val moviesResult: List<Movie> = generator()
            _mutableMoviesList.setValue(moviesResult)
        }
    }
}