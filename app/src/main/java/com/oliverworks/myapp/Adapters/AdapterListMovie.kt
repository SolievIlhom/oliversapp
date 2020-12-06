package com.oliverworks.myapp.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.recyclerview.widget.RecyclerView
import com.oliverworks.myapp.Classes.Movie
import com.oliverworks.myapp.R


class AdapterListMovie(private val onItemClickListener: (Int) -> Unit) :
    RecyclerView.Adapter<AdapterListMovie.MovieViewHolder>() {
    private var movies = listOf<Movie>()
    private lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.view_holder_movie, parent, false)
        context = view.context
        return MovieViewHolder(view, onItemClickListener)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie: Movie = movies[position]
        with(holder) {
            name.text = movie.name
            rating.rating = movie.rating
            reviews.text = "${movie.reviews} REVIEWS"
            if (movie.like) {
                like.setImageDrawable(getDrawable(context, R.drawable.like_true_icon))
            } else {
                like.setImageDrawable(getDrawable(context, R.drawable.like_icon))
            }
            posterPath.setImageDrawable(getDrawable(context, movie.posterPath))
            limitAge.text = "${movie.limitAge} +"
            durationOfFilm.text = "${movie.durationMin}MIN"
            tag.text = movie.tag
        }
    }

    override fun getItemCount(): Int = movies.size

    fun bindFilms(newListOfFilms: List<Movie>) {
        movies = newListOfFilms
        notifyDataSetChanged()
    }

    class MovieViewHolder(itemView: View, onItemClickListener: (Int) -> Unit) :
        RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener {
                onItemClickListener(adapterPosition)
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


