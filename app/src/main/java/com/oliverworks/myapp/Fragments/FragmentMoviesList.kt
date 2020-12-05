package com.oliverworks.myapp.Fragments
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.oliverworks.myapp.Adapters.AdapterListMovie
import com.oliverworks.myapp.Classes.Movie
import com.oliverworks.myapp.Extras.Words
import com.oliverworks.myapp.R

class FragmentMoviesList : Fragment() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter : AdapterListMovie
    lateinit var textViewLabel : TextView
    val list  = mutableListOf<Movie>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view : View = inflater.inflate(R.layout.fragment_movies_list, container, false)
        textViewLabel = view.findViewById(R.id.textViewLabelMovieLList)
        list.add(Movie("Avengers: End Game",3f,100,false,13,100,"Action, Adventure, Drama",R.drawable.movie_backgound_avengers,getString(R.string.storyline_of_film_avengers)))
        list.add(Movie("Tenet",1f,100,true,16,100,"Action, Adventure, Drama",R.drawable.movie_background_tenet,getString(R.string.storyline_of_film_avengers)))
        list.add(Movie("Black Widow",4f,100,false,13,100,"Action, Adventure, Drama",R.drawable.movie_background_black_widow,getString(R.string.storyline_of_film_avengers)))
        list.add(Movie("Wonder Woman 1984",5f,100,false,13,100,"Action, Adventure, Drama",R.drawable.movie_background_wonder_woman,getString(R.string.storyline_of_film_avengers)))
        adapter = AdapterListMovie(view.context)
        recyclerView = view.findViewById(R.id.recyclerView)
        adapter.bindFilms(list)
        adapter.setOnItemClickListener(object : AdapterListMovie.OnItemClickListener{
            override fun onItemClick(position: Int) {
                goToDetailsFragment(position)
            }
        })
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(view.context,2)
        return view
    }

    fun goToDetailsFragment(position: Int){
        val fragment : FragmentMoviesDetails = setDataToFragment(position)
        activity?.supportFragmentManager?.beginTransaction()
                ?.add(R.id.mainActivityBackground, fragment)
                ?.addToBackStack(null)
                ?.commit()
    }

    fun setDataToFragment(position : Int) : FragmentMoviesDetails{
        val fragment : FragmentMoviesDetails = FragmentMoviesDetails()
        val bundle : Bundle  = Bundle()
        bundle.putParcelable(Words.MOVIE,list[position])
        fragment.arguments = bundle
        return fragment
    }

}