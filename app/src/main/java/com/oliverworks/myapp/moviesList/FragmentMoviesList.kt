package com.oliverworks.myapp.moviesList

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.oliverworks.myapp.R
import com.oliverworks.myapp.Router
import com.oliverworks.myapp.data.classes.Movie
import com.oliverworks.myapp.moviesList.adapter.AdapterListMovie
import com.oliverworks.myapp.moviesList.viewModel.ViewModelFactoryMoviesList
import com.oliverworks.myapp.moviesList.viewModel.ViewModelListMovies
import ru.petrgostev.myfirstproject.data.jsоn.MoviesGet

class FragmentMoviesList : Fragment(R.layout.fragment_movies_list) {

    private val parentRouter: Router? get() = (activity as? Router)
    private lateinit var recyclerView: RecyclerView
    private val viewModel: ViewModelListMovies by viewModels {
        ViewModelFactoryMoviesList(
            MoviesGet(
                requireContext()
            )
        )
    }
    private val adapter: AdapterListMovie by lazy {
        AdapterListMovie { movie: Movie ->
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

    fun updateAdapter(movies: List<Movie>) {
        adapter.bindFilms(movies)
    }

    fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.recyclerView)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(view.context, 2)
    }

}