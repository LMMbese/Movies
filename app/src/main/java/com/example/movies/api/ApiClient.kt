package com.example.movies.api

import com.example.movies.constants.BASE_URL
import com.example.movies.movies.service.GetMovieService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    companion object {
        private fun getRetrofitInstance(): Retrofit.Builder {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
        }

        fun getMovieService(): GetMovieService {
            return getRetrofitInstance().build().create(GetMovieService::class.java)
        }
    }
}