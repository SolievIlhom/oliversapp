package com.oliverworks.myapp.moviesList

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.academy.fundamentals.homework.features.data.Movie
import com.oliverworks.myapp.R
import com.oliverworks.myapp.extras.FillList
import com.oliverworks.myapp.extras.Words
import com.oliverworks.myapp.moviesDetails.FragmentMoviesDetails
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FragmentMoviesList : Fragment(R.layout.fragment_movies_list) {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AdapterListMovie
    private lateinit var textViewLabel: TextView
    private var list = listOf<Movie>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = view.findViewById(R.id.recyclerView)
        CoroutineScope(Dispatchers.Main).launch {
            list = FillList.getMovies(requireContext())
            initRecycler(view)
        }
        textViewLabel = view.findViewById(R.id.textViewLabelMovieLList)
    }

    fun initRecycler(view: View) {
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