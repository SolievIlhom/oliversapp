package com.oliverworks.myapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.oliverworks.myapp.data.pojo.moviesDetails.MovieDetails

@Database(entities = [MovieDetails::class],version = 1,exportSchema = false)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun getDao():MovieDao
    companion object{
        var instance: MovieDatabase? = null
        fun getInstance(context: Context) : MovieDatabase{
            if(instance != null){
                return instance as MovieDatabase
            }
            val ins = Room.databaseBuilder(context,MovieDatabase::class.java,"db_movie_database").build()
            instance = ins
            return ins
        }
    }

}