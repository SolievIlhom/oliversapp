package com.oliverworks.myapp.fragments.moviesDetails

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.oliverworks.myapp.R
import com.oliverworks.myapp.data.pojo.moviesDetails.MovieDetails


class FragmentMoviesDetails : Fragment(R.layout.fragment_movies_details) {

    private lateinit var textViewFilmName: TextView
    private lateinit var textViewAgeLimit: TextView
    private lateinit var textViewFilmReview: TextView
    private lateinit var textViewTag: TextView
    private lateinit var textViewShortlineOfFilm: TextView
    private lateinit var ratingBar: RatingBar
    private lateinit var recyclerView: RecyclerView
    private lateinit var imageViewBackdrop: ImageView
    private val adapter: AdapterDetailsMovieActors = AdapterDetailsMovieActors()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
        setDataToFragment(getDataFromFragmentDetails())
    }

    private fun getDataFromFragmentDetails(): MovieDetails =
        requireArguments().getParcelable(ARG_MOVIE)!!

    private fun setDataToFragment(movie: MovieDetails) {
        with(movie) {
            textViewFilmName.text = movie.title
            textViewAgeLimit.text = if (adult == true) "16+" else "13+"
            textViewFilmReview.text = "${runtime} REVIEWS"
            // TODO
           // textViewTag.text = genres?.map { it.name }.toString()
            textViewShortlineOfFilm.text = overview
            ratingBar.rating = (voteAverage!! / 2).toFloat()
            Glide.with(requireContext())
                .load(getImageSizeBackdrop500())
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(imageViewBackdrop)
        }
    }

    private fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.recyclerViewActors)
        recyclerView.adapter = adapter
        recyclerView.layoutManager =
            LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)
        textViewFilmName = view.findViewById(R.id.nameFilm)
        textViewAgeLimit = view.findViewById(R.id.textViewAgeLimit)
        textViewFilmReview = view.findViewById(R.id.textViewFilmReview)
        textViewTag = view.findViewById(R.id.textViewTag)
        textViewShortlineOfFilm = view.findViewById(R.id.textViewShortlineOfFilm)
        ratingBar = view.findViewById(R.id.ratingBarFragmentDeatails)
        imageViewBackdrop = view.findViewById(R.id.imageViewBackdropFilmDetails)
    }

    companion object {

        private const val ARG_MOVIE = "movie"

        fun newInstance(movie: MovieDetails): FragmentMoviesDetails {
            return FragmentMoviesDetails().apply {
                arguments = bundleOf(
                    ARG_MOVIE to movie
                )
            }
        }
    }

}