package com.example.movies.movies.viewmodel

import androidx.lifecycle.ViewModel
import com.example.movies.movies.repository.MovieRepository

class MovieViewModel (repo: MovieRepository) : ViewModel() {
    val movie = repo.movie
}