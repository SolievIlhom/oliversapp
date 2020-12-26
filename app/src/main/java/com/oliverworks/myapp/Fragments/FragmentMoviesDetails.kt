package com.oliverworks.myapp.Fragments

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.academy.fundamentals.homework.features.data.Genre
import com.android.academy.fundamentals.homework.features.data.Movie
import com.bumptech.glide.Glide
import com.oliverworks.myapp.Adapters.AdapterDetailsMovie
import com.oliverworks.myapp.R


class FragmentMoviesDetails : Fragment(R.layout.fragment_movies_details) {

    private lateinit var textViewFilmName: TextView
    private lateinit var textViewAgeLimit: TextView
    private lateinit var textViewFilmReview: TextView
    private lateinit var textViewTag: TextView
    private lateinit var textViewShortlineOfFilm: TextView
    private lateinit var ratingBar: RatingBar
    private lateinit var recyclerView: RecyclerView
    private lateinit var imageViewBackdrop: ImageView

    private lateinit var adapter: AdapterDetailsMovie
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        findIdAndSetFields(view)
        val movie: Movie = getDataFromFragmentDetails()
        setDataToFragment(movie)
        val listActors = movie.actors
        adapter = AdapterDetailsMovie()
        adapter.bindActors(listActors)
        recyclerView.adapter = adapter
        recyclerView.layoutManager =
            LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)
    }

    fun getDataFromFragmentDetails(): Movie = arguments?.getParcelable("movie")!!
    fun setDataToFragment(movie: Movie) {
        //Texts
        textViewFilmName.text = movie.title
        textViewAgeLimit.text = "${movie.adult}+"
        textViewFilmReview.text = "${movie.runtime} REVIEWS"
        textViewTag.text = Genre.toStringName(movie.genres)
        textViewShortlineOfFilm.text = movie.overview
        //Ratings
        ratingBar.rating = movie.startRating
        //images
        Glide.with(this)
            .load(movie.backdrop)
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(imageViewBackdrop)
    }

    fun findIdAndSetFields(view: View) {
        recyclerView = view.findViewById(R.id.recyclerViewActors)
        textViewFilmName = view.findViewById(R.id.nameFilm)
        textViewAgeLimit = view.findViewById(R.id.textViewAgeLimit)
        textViewFilmReview = view.findViewById(R.id.textViewFilmReview)
        textViewTag = view.findViewById(R.id.textViewTag)
        textViewShortlineOfFilm = view.findViewById(R.id.textViewShortlineOfFilm)
        ratingBar = view.findViewById(R.id.ratingBarFragmentDeatails)
        imageViewBackdrop = view.findViewById(R.id.imageViewBackdropFilmDetails)
    }

}