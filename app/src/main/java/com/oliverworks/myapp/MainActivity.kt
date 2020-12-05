package com.oliverworks.myapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.oliverworks.myapp.Fragments.FragmentMoviesList


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .apply {
                add(R.id.mainActivityBackground, FragmentMoviesList())
               //addToBackStack(null)
                commit()
            }
    }
}