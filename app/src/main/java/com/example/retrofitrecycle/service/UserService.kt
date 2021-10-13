package com.example.retrofitrecycle.service

import com.example.retrofitrecycle.model.Movie
import retrofit2.http.GET
import retrofit2.Call

interface UserService {

    @GET("movielist.json")
    fun getMovieList(): Call<List<Movie>>
    
}