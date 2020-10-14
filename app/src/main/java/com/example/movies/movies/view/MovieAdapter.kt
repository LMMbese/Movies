package com.example.movies.movies.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.VisibleForTesting
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movies.R
import com.example.movies.movies.data.Movie

class MovieAdapter(
    private val context: Context,
    private val movies: List<Movie>
) : RecyclerView.Adapter<MovieAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val rootView = getLayoutInflater(parent.context).inflate(R.layout.list_row, parent, false)
        return MyViewHolder(rootView)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val movie = movies[position]


        Glide.with(context)
            .load(movie.poster)
            .override(200, 200)
            .centerCrop()
            .into(holder.topView)

        holder.title.text = context.getString(R.string.movie_title, movie.title)
        holder.year.text = context.getString(R.string.movie_year, movie.year)
        holder.rated.text =context.getString(R.string.movie_rated, movie.rated)
        holder.released.text = context.getString(R.string.movie_released, movie.released)
        holder.runtime.text =context.getString(R.string.movie_runtime, movie.runtime)
        holder.genre.text =context.getString(R.string.movie_genre, movie.genre)
        holder.writer.text =context.getString(R.string.movie_writer,movie.writer)
        holder.actors.text =context.getString(R.string.movie_actors,movie.actors)
        holder.language.text =context.getString(R.string.movie_language,movie.language)
        holder.country.text =context.getString(R.string.movie_country,movie.country)
        holder.awards.text =context.getString(R.string.movie_awards,movie.awards)
        holder.production.text =context.getString(R.string.movie_production,movie.production)
        holder.type.text =context.getString(R.string.movie_type,movie.type)
        holder.metaScore.text =context.getString(R.string.movie_metaScore,movie.metascore)
        holder.plot.text =context.getString(R.string.movie_plot,movie.plot)
        holder.imdbID.text =context.getString(R.string.movie_imdbID,movie.imdbid)
        holder.imdbRating.text =context.getString(R.string.movie_imdbRating,movie.imdbrating)
        holder.imdbVotes.text =context.getString(R.string.movie_imdbVotes,movie.imdbvotes)
        holder.director.text =context.getString(R.string.movie_director,movie.director)
    }

    @VisibleForTesting
    internal fun getLayoutInflater(context: Context): LayoutInflater {
        return LayoutInflater.from(context)
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val topView: ImageView = itemView.findViewById(R.id.top_view)
        val title: TextView = itemView.findViewById(R.id.movie_title)
        val year: TextView = itemView.findViewById(R.id.movie_year)
        val rated: TextView = itemView.findViewById(R.id.movie_rated)
        val released: TextView = itemView.findViewById(R.id.movie_released)
        val runtime: TextView = itemView.findViewById(R.id.movie_run_time)
        val genre: TextView = itemView.findViewById(R.id.movie_genre)
        val writer: TextView = itemView.findViewById(R.id.movie_writers)
        val actors: TextView = itemView.findViewById(R.id.movie_actors)
        val language: TextView = itemView.findViewById(R.id.movie_language)
        val country: TextView = itemView.findViewById(R.id.movie_country)
        val awards: TextView = itemView.findViewById(R.id.movie_awards)
        val production: TextView = itemView.findViewById(R.id.movie_production)
        val type: TextView = itemView.findViewById(R.id.movie_type)
        val metaScore: TextView = itemView.findViewById(R.id.movie_metaScore)
        val imdbRating: TextView = itemView.findViewById(R.id.movie_imdbRating)
        val imdbVotes: TextView = itemView.findViewById(R.id.movie_imdbVotes)
        val imdbID: TextView = itemView.findViewById(R.id.movie_imdbID)
        val plot: TextView = itemView.findViewById(R.id.movie_plot)
        val director: TextView = itemView.findViewById(R.id.movie_director)
    }
}