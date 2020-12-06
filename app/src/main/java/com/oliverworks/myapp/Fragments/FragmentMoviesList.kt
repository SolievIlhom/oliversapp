package com.oliverworks.myapp.Fragments

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.oliverworks.myapp.Adapters.AdapterListMovie
import com.oliverworks.myapp.Classes.FillList
import com.oliverworks.myapp.Extras.Words
import com.oliverworks.myapp.R

class FragmentMoviesList : Fragment(R.layout.fragment_movies_list) {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AdapterListMovie
    private lateinit var textViewLabel: TextView
    private val list = FillList.getMovies()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        textViewLabel = view.findViewById(R.id.textViewLabelMovieLList)
        initRecycler(view)
    }

    fun initRecycler(view: View) {
        recyclerView = view.findViewById(R.id.recyclerView)
        adapter = AdapterListMovie {
            goToDetailsFragment(it)
        }
        adapter.bindFilms(list)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(view.context, 2)
    }

    fun goToDetailsFragment(position: Int) {
        val fragment: FragmentMoviesDetails = setDataToFragment(position)
        activity?.supportFragmentManager?.beginTransaction()
            ?.add(R.id.mainActivityBackground, fragment)
            ?.addToBackStack(null)
            ?.commit()
    }

    fun setDataToFragment(position: Int): FragmentMoviesDetails {
        val fragment: FragmentMoviesDetails = FragmentMoviesDetails()
        val bundle: Bundle = Bundle()
        bundle.putParcelable(Words.MOVIE, list[position])
        fragment.arguments = bundle
        return fragment
    }

}