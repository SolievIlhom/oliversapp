package com.oliverworks.myapp.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.oliverworks.myapp.Adapters.AdapterDetailsMovie
import com.oliverworks.myapp.Classes.Actor
import com.oliverworks.myapp.Classes.Movie
import com.oliverworks.myapp.R


class FragmentMoviesDetails : Fragment() {

    lateinit var textViewFilmName : TextView
    lateinit var textViewAgeLimit : TextView
    lateinit var textViewFilmReview : TextView
    lateinit var textViewTag : TextView
    lateinit var textViewShortlineOfFilm : TextView
    lateinit var ratingBar : RatingBar

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: AdapterDetailsMovie
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view : View = inflater.inflate(R.layout.fragment_movies_details, container, false)
        val list = mutableListOf<Actor>()
        list.add(Actor("Robert Downey Jr.",R.drawable.robert_actor))
        list.add(Actor("Chris Evans",R.drawable.evans_actor))
        list.add(Actor("Mark Ruffalo",R.drawable.mark_actor))
        list.add(Actor("Chris Hemsworth",R.drawable.chris_actor))
        findIdAndSetFields(view)
        adapter = AdapterDetailsMovie(view.context)
        adapter.bindActors(list)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(view.context,LinearLayoutManager.HORIZONTAL,false)
        val movie : Movie = getDataFromFragmentDetails()
        setDataToFragment(movie)
        return view
    }
    fun getDataFromFragmentDetails() : Movie  = arguments?.getParcelable("movie")!!

    fun setDataToFragment(movie : Movie){
        textViewFilmName.text = movie.name
        textViewAgeLimit.text = movie.limitAge.toString() + "+"
        textViewFilmReview.text = movie.reviews.toString() + "REVIEWS"
        textViewTag.text = movie.tag
        textViewShortlineOfFilm.text = movie.shortline
        ratingBar.setRating(movie.rating)
    }
    fun findIdAndSetFields(view : View){
        recyclerView = view.findViewById(R.id.recyclerViewActors)
        textViewFilmName = view.findViewById(R.id.nameFilm)
        textViewAgeLimit = view.findViewById(R.id.textViewAgeLimit)
        textViewFilmReview = view.findViewById(R.id.textViewFilmReview)
        textViewTag = view.findViewById(R.id.textViewTag)
        textViewShortlineOfFilm= view.findViewById(R.id.textViewShortlineOfFilm)
        ratingBar = view.findViewById(R.id.ratingBarFragmentDeatails)
    }
}