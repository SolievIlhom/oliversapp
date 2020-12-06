package com.oliverworks.myapp.Classes

import com.oliverworks.myapp.R

class FillList {
    companion object {
        fun getActors(): List<Actor> {
            val list = mutableListOf<Actor>()
            list.add(Actor("Robert Downey Jr.", R.drawable.robert_actor))
            list.add(Actor("Chris Evans", R.drawable.evans_actor))
            list.add(Actor("Mark Ruffalo", R.drawable.mark_actor))
            list.add(Actor("Chris Hemsworth", R.drawable.chris_actor))
            return list
        }

        fun getMovies(): List<Movie> {
            val list = mutableListOf<Movie>()
            list.add(
                Movie(
                    "Avengers: End Game",
                    3f,
                    100,
                    false,
                    13,
                    100,
                    "Action, Adventure, Drama",
                    R.drawable.movie_backgound_avengers,
                    "getString(R.string.storyline_of_film_avengers)"
                )
            )
            list.add(
                Movie(
                    "Tenet",
                    1f,
                    100,
                    true,
                    16,
                    100,
                    "Action, Adventure, Drama",
                    R.drawable.movie_background_tenet,
                    "getString(R.string.storyline_of_film_avengers)"
                )
            )
            list.add(
                Movie(
                    "Black Widow",
                    4f,
                    100,
                    false,
                    13,
                    100,
                    "Action, Adventure, Drama",
                    R.drawable.movie_background_black_widow,
                    "getString(R.string.storyline_of_film_avengers)"
                )
            )
            list.add(
                Movie(
                    "Wonder Woman 1984",
                    5f,
                    100,
                    false,
                    13,
                    100,
                    "Action, Adventure, Drama",
                    R.drawable.movie_background_wonder_woman,
                    "getString(R.string.storyline_of_film_avengers)"
                )
            )
            return list
        }
    }
}