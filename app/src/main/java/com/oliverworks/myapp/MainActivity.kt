package com.oliverworks.myapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(),GoToDetailsListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .apply {
                add(R.id.listContainer,FragmentMoviesList())
                commit()
            }
    }

    override fun goToDetails() {
        supportFragmentManager.beginTransaction().apply {
            add(R.id.mainActivityBackground,FragmentMoviesDetails())
            addToBackStack(null)
            commit()
        }
    }

}