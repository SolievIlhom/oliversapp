package com.oliverworks.myapp.Fragments

import android.os.Bundle
import android.view.View
import android.widget.RatingBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.oliverworks.myapp.Adapters.AdapterDetailsMovie
import com.oliverworks.myapp.Classes.FillList
import com.oliverworks.myapp.Classes.Movie
import com.oliverworks.myapp.R


class FragmentMoviesDetails : Fragment(R.layout.fragment_movies_details) {
    private lateinit var textViewFilmName: TextView
    private lateinit var textViewAgeLimit: TextView
    private lateinit var textViewFilmReview: TextView
    private lateinit var textViewTag: TextView
    private lateinit var textViewShortlineOfFilm: TextView
    private lateinit var ratingBar: RatingBar
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AdapterDetailsMovie

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list = FillList.getActors()
        findIdAndSetFields(view)
        adapter = AdapterDetailsMovie()
        adapter.bindActors(list)
        recyclerView.adapter = adapter
        recyclerView.layoutManager =
            LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)
        val movie: Movie = getDataFromFragmentDetails()
        setDataToFragment(movie)
    }

    fun getDataFromFragmentDetails(): Movie = arguments?.getParcelable("movie")!!

    fun setDataToFragment(movie: Movie) {
        textViewFilmName.text = movie.name
        textViewAgeLimit.text = movie.limitAge.toString() + "+"
        textViewFilmReview.text = movie.reviews.toString() + "REVIEWS"
        textViewTag.text = movie.tag
        textViewShortlineOfFilm.text = movie.shortline
        ratingBar.setRating(movie.rating)
    }

    fun findIdAndSetFields(view: View) {
        recyclerView = view.findViewById(R.id.recyclerViewActors)
        textViewFilmName = view.findViewById(R.id.nameFilm)
        textViewAgeLimit = view.findViewById(R.id.textViewAgeLimit)
        textViewFilmReview = view.findViewById(R.id.textViewFilmReview)
        textViewTag = view.findViewById(R.id.textViewTag)
        textViewShortlineOfFilm = view.findViewById(R.id.textViewShortlineOfFilm)
        ratingBar = view.findViewById(R.id.ratingBarFragmentDeatails)
    }

}