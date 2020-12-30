package com.oliverworks.myapp.moviesList.adapter

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
import com.oliverworks.myapp.data.classes.Genre
import com.oliverworks.myapp.data.classes.Movie


class AdapterListMovie(private val onItemClickListener: (Movie) -> Unit) :
    RecyclerView.Adapter<AdapterListMovie.MovieViewHolder>() {

    private var movies = listOf<Movie>()

    private lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.view_holder_movie, parent, false)
        context = view.context
        return MovieViewHolder(view, onItemClickListener,movies)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie: Movie = movies[position]
        with(holder) {
            name.text = movie.title
            rating.rating = movie.startRating
            reviews.text = context.getString(R.string.reviews_label)
            Glide.with(context)
                .load(movie.poster)
                .placeholder(R.drawable.ic_launcher_background)
                .into(posterPath)
            limitAge.text = context.getString(R.string.limitage_label_view_holder,movie.adult.toString())
            durationOfFilm.text = context.getString(R.string.duration_of_film_label_view_holder,movie.runtime.toString())
            tag.text = Genre.toStringName(movie.genres)
        }
    }

    override fun getItemCount(): Int = movies.size

    fun bindFilms(newListOfFilms: List<Movie>) {
        movies = newListOfFilms
        notifyDataSetChanged()
    }

    class MovieViewHolder(itemView: View, onItemClickListener: (Movie) -> Unit, movies : List<Movie>) : RecyclerView.ViewHolder(itemView) {
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


