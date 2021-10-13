package com.example.retrofitrecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.retrofitrecycle.model.Movie
import com.example.retrofitrecycle.network.ApiManager
import com.example.retrofitrecycle.service.MovieService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.java.simpleName
    lateinit var movieService : MovieService
    var movieList: List<Movie>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fetchMovie()
    }

    private fun fetchMovie() {
        movieService = ApiManager.movieService

        movieService.getMovieList().enqueue(object : Callback<List<Movie>> {
            override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
                if(response.isSuccessful){
                    movieList = response.body()
                    movieList?.let{
                        for((i, movie) in it.withIndex()) {
                            Log.d(TAG, "SUCCESS: movie $i is $movie")
                        }
                    } ?: run {
                        Log.d(TAG, "FAILURE: movielist was null")
                    }
                }else{
                    Log.d(TAG, "Error: ${response.code()} body: ${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                Log.d(TAG, t.localizedMessage ?: "Stacce!!!!", t)
            }

        })
    }

}