package com.oliverworks.myapp.fragments.moviesList

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.oliverworks.movieapphomeworktest.api.RetrofitModule
import com.oliverworks.myapp.data.pojo.moviesDetails.MovieDetails
import com.oliverworks.myapp.database.MovieDatabase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModelListMovies(application: Application) : AndroidViewModel(application) {

    private val db by lazy{
        MovieDatabase.getInstance(application).getDao()
    }

    val moviesList: LiveData<List<MovieDetails>> = db.getList()

    fun loadMovies() {
        viewModelScope.launch(Dispatchers.IO + handler) {
            val movie = RetrofitModule.moviesApi.getMovies()
            movie.results?.forEach {
                val detail: MovieDetails =
                    RetrofitModule.moviesApi.getMovieDetails(movie_id = it.id)
                db.add(detail)
            }
        }

    }
    private val handler = CoroutineExceptionHandler(handler = { _, error ->
        Log.d("MainViewModel","Something went wrong")
    })
}