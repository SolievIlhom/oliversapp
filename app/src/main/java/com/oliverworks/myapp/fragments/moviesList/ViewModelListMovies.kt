package com.oliverworks.myapp.fragments.moviesList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oliverworks.movieapphomeworktest.api.RetrofitModule
import com.oliverworks.myapp.data.pojo.moviesDetails.MovieDetails
import kotlinx.coroutines.launch

class ViewModelListMovies() : ViewModel() {

    private var _moviesList = MutableLiveData<List<MovieDetails>>(emptyList())
    val moviesList: LiveData<List<MovieDetails>> get() = _moviesList

    fun loadMovies() {
        viewModelScope.launch {
            val movie = RetrofitModule.moviesApi.getMovies()
            val moviesDetails: MutableList<MovieDetails> = mutableListOf()
            movie.results?.forEach {
                val detail: MovieDetails =
                    RetrofitModule.moviesApi.getMovieDetails(movie_id = it.id)
                moviesDetails.add(detail)
            }
            _moviesList.postValue(moviesDetails)
        }
    }
}