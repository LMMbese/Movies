package com.example.movies.movies.service

import com.example.movies.movies.data.Movie
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GetMovieService {
    @GET("?i=tt3896198")
    suspend fun getMovie(@Query("apikey") apiKey : String) : Response<Movie>
}