package com.oliverworks.myapp.fragments.moviesList

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.oliverworks.myapp.R
import com.oliverworks.myapp.data.pojo.moviesDetails.MovieDetails


class AdapterListMovie(private val onItemClickListener: (MovieDetails) -> Unit) :
    RecyclerView.Adapter<AdapterListMovie.MovieViewHolder>() {

    private var movies = listOf<MovieDetails>()
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.view_holder_movie, parent, false)
        context = view.context
        return MovieViewHolder(view, onItemClickListener, movies)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie: MovieDetails = movies[position]
        with(holder) {
            name.text = movie.title
            rating.rating = movie.voteAverage.toFloat() / 2
            reviews.text = context.getString(R.string.reviews_label)
            Glide.with(context)
                .load(movie.getImageSizePoster500())
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(posterPath)
            limitAge.text =
                context.getString(R.string.limitage_label_view_holder, movie.adult.toString())
            durationOfFilm.text = context.getString(
                R.string.duration_of_film_label_view_holder,
                movie.runtime.toString()
            )
            tag.text = movie.genres?.map { it.name }.toString()

        }
    }

    override fun getItemCount(): Int = movies.size

    fun bindFilms(newListOfFilms: List<MovieDetails>) {
        movies = newListOfFilms
        notifyDataSetChanged()
    }

    class MovieViewHolder(
        itemView: View,
        onItemClickListener: (MovieDetails) -> Unit,
        movies: List<MovieDetails>
    ) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener {
                onItemClickListener(movies[adapterPosition])
            }
        }

        val name: TextView = itemView.findViewById(R.id.textViewNameOfFilmHolder)
        val rating: RatingBar = itemView.findViewById(R.id.ratingBar)
        val reviews: TextView = itemView.findViewById(R.id.textViewReviewsOfFilm)
        val like: ImageView = itemView.findViewById(R.id.likeIconOfFilm)
        val limitAge: TextView = itemView.findViewById(R.id.filmLimitAge)
        val durationOfFilm: TextView = itemView.findViewById(R.id.textViewDurationOfFilm)
        val tag: TextView = itemView.findViewById(R.id.textViewViewHolderTag)
        val posterPath: ImageView = itemView.findViewById(R.id.backgroundHolder)
    }
}


