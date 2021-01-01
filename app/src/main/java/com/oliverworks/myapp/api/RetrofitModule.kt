package com.oliverworks.movieapphomeworktest.api

import com.oliverworks.myapp.api.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitModule {

    private val BASE_URL = "https://api.themoviedb.org/3/"
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val moviesApi: ApiService = retrofit.create(ApiService::class.java)

}