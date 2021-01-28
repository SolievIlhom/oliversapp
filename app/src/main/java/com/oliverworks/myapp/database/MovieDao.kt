package com.oliverworks.myapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.oliverworks.myapp.data.pojo.moviesDetails.MovieDetails

@Dao
interface MovieDao {
    @Insert
    suspend fun add(movie:MovieDetails)

    @Query("SELECT * FROM movie_details")
    fun getList() : LiveData<List<MovieDetails>>

}