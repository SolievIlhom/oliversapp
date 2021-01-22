package com.oliverworks.myapp.fragments.moviesList

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.oliverworks.myapp.R
import com.oliverworks.myapp.Router
import com.oliverworks.myapp.data.pojo.moviesDetails.MovieDetails

class FragmentMoviesList : Fragment(R.layout.fragment_movies_list) {

    private val parentRouter: Router? by lazy { (activity as? Router) }
    private lateinit var recyclerView: RecyclerView
    private val viewModel: ViewModelListMovies by lazy { ViewModelListMovies() }

    private val adapter: AdapterListMovie by lazy {
        AdapterListMovie { movie: MovieDetails ->
            parentRouter?.openMoviesDetailsFragment(
                movie
            )
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.loadMovies()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
        viewModel.moviesList.observe(this.viewLifecycleOwner, this::updateAdapter)
    }

    private fun updateAdapter(movies: List<MovieDetails>) {
        adapter.bindFilms(movies)
    }

    private fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(view.context, NUMBER_OF_CAGES_RECYCLER_VIEW)
    }

    companion object {
        private const val NUMBER_OF_CAGES_RECYCLER_VIEW = 2
    }
}

