package com.example.retrofitrecycle.network

import com.example.retrofitrecycle.service.MovieService
import retrofit2.Retrofit.Builder
import retrofit2.converter.gson.GsonConverterFactory

class ApiManager {

    companion object {
        val BASE_URL = "https://howtodoandroid.com/"
        val retrofit = Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()

        val movieService = retrofit.create(MovieService::class.java)
    }

}