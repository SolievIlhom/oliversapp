package com.oliverworks.myapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.oliverworks.myapp.data.classes.Movie
import com.oliverworks.myapp.moviesDetails.FragmentMoviesDetails
import com.oliverworks.myapp.moviesList.FragmentMoviesList


class MainActivity : AppCompatActivity(), Router {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.mainActivityBackground, FragmentMoviesList())
                .commit()
        }
    }

    override fun openMoviesDetailsFragment(movie: Movie) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.mainActivityBackground, FragmentMoviesDetails.newInstance(movie))
            .addToBackStack(FragmentMoviesDetails::class.java.name)
            .commit()
    }
}