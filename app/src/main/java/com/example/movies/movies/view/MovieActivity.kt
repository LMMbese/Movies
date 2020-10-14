package com.example.movies.movies.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movies.R
import com.example.movies.api.ApiClient
import com.example.movies.constants.API_KEY
import com.example.movies.movies.data.Movie
import com.example.movies.movies.viewmodel.MovieViewModel
import org.koin.android.ext.android.inject
import retrofit2.Response
import javax.security.auth.callback.Callback

class MovieActivity : AppCompatActivity() {

    private val viewModel by inject<MovieViewModel>()
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MovieAdapter
    private lateinit var progressBar: ProgressBar
    private lateinit var movies: ArrayList<Movie>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar = findViewById(R.id.progressBar)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        movies = ArrayList()

        adapter = MovieAdapter(this, movies)

        recyclerView.adapter = adapter

        showMovie()
    }

    private fun showMovie() {
        viewModel.movie.observe(this, Observer {
            progressBar.visibility = View.GONE
            it?.let {
                it1 -> movies.add(it1)
            }
            adapter.notifyDataSetChanged()
        })
    }
}