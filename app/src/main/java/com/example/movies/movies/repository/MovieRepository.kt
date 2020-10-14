package com.example.movies.movies.repository

import android.util.Log
import androidx.annotation.WorkerThread
import androidx.lifecycle.MutableLiveData
import com.example.movies.api.ApiClient
import com.example.movies.constants.API_KEY
import com.example.movies.movies.data.Movie
import com.example.movies.movies.data.MovieDao
import com.example.movies.movies.service.GetMovieService
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieRepository(
    private val dao: MovieDao,
    private val apiService: GetMovieService = ApiClient.getMovieService()
) {
    val movie = MutableLiveData<Movie>()

    private val handler = CoroutineExceptionHandler { _, exception ->
        Log.d("", "$exception handled !")
    }

    init {
        CoroutineScope(Dispatchers.IO + handler).launch {
            kotlin.runCatching {
                getMovie()
            }
        }
    }

    @WorkerThread
    suspend fun getMovie() {
        var movieData = dao.getMovie().value
        if (movieData == null) {
            movieData = apiService.getMovie(API_KEY).body()
            if (movieData != null) {
                movie.postValue(movieData)
                dao.insert(movieData)
            }
        } else {
            movie.postValue(movieData)
        }
    }
}