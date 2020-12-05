package com.oliverworks.myapp.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.recyclerview.widget.RecyclerView
import com.oliverworks.myapp.Classes.Movie
import com.oliverworks.myapp.R

class AdapterListMovie(private val context : Context) : RecyclerView.Adapter<ViewHolder>() {
    private var movies = mutableListOf<Movie>()
    fun bindFilms(newListOfFilms: List<Movie>){
        movies = newListOfFilms as MutableList<Movie>
        notifyDataSetChanged()
    }
    private lateinit var listener :OnItemClickListener
    interface OnItemClickListener{
        fun onItemClick(position:Int)
    }
    fun setOnItemClickListener (listener : OnItemClickListener){
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_movie, parent, false)
        return ViewHolder(view,context,listener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie : Movie = movies[position]
        holder.name.text = movie.name
        holder.rating.setRating(movie.rating)
        holder.reviews.text = movie.reviews.toString() + " REVIEWS"
        if(movie.like){
            holder.like.setImageDrawable(getDrawable(context,R.drawable.like_true_icon))
        }else {
            holder.like.setImageDrawable(getDrawable(context,R.drawable.like_icon))
        }
        holder.posterPath.setImageDrawable(getDrawable(context, movie.posterPath))
        holder.limitAge.text = movie.limitAge.toString() + "+"
        holder.durationOfFilm.text = movie.durationMin.toString() + "MIN"
        holder.tag.text = movie.tag
    }

    override fun getItemCount(): Int {
     return movies.size
    }
}
class ViewHolder(itemView: View,context: Context,listener : AdapterListMovie.OnItemClickListener) : RecyclerView.ViewHolder(itemView) {
    init {
        itemView.setOnClickListener {
            Toast.makeText(context,"Hello from $adapterPosition" ,Toast.LENGTH_LONG).show()
            listener.onItemClick(adapterPosition)
        }
    }
    val name: TextView = itemView.findViewById(R.id.textViewNameOfFilmHolder)
    val rating: RatingBar = itemView.findViewById(R.id.ratingBar)
    val reviews: TextView = itemView.findViewById(R.id.textViewReviewsOfFilm)
    val like:ImageView = itemView.findViewById(R.id.likeIconOfFilm)
    val limitAge: TextView = itemView.findViewById(R.id.filmLimitAge)
    val durationOfFilm: TextView = itemView.findViewById(R.id.textViewDurationOfFilm)
    val tag: TextView = itemView.findViewById(R.id.textViewViewHolderTag)
    val posterPath:  ImageView = itemView.findViewById(R.id.backgroundHolder)
}