package com.oliverworks.myapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.oliverworks.myapp.data.pojo.moviesDetails.MovieDetails
import com.oliverworks.myapp.fragments.moviesDetails.FragmentMoviesDetails
import com.oliverworks.myapp.fragments.moviesList.FragmentMoviesList


class MainActivity : AppCompatActivity(), Router {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.mainActivityBackground, FragmentMoviesList())
                .commit()
        }
    }

    override fun openMoviesDetailsFragment(movie: MovieDetails) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.mainActivityBackground, FragmentMoviesDetails.newInstance(movie))
            .addToBackStack(FragmentMoviesDetails::class.java.name)
            .commit()
    }
}