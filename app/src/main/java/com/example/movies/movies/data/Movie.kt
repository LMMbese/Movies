package com.example.movies.movies.data

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movie")
data class Movie(
    @PrimaryKey
    @field:SerializedName("Title") val title: String,
    @field:SerializedName("Year") val year: String,
    @field:SerializedName("Rated") val rated: String,
    @field:SerializedName("Released") val released: String,
    @field:SerializedName("Runtime") val runtime: String,
    @field:SerializedName("Genre") val genre: String,
    @field:SerializedName("Director") val director: String,
    @field:SerializedName("Writer") val writer: String,
    @field:SerializedName("Actors") val actors: String,
    @field:SerializedName("Plot") val plot: String,
    @field:SerializedName("Language") val language: String,
    @field:SerializedName("Country") val country: String,
    @field:SerializedName("Awards") val awards: String,
    @field:SerializedName("Poster") val poster: String,
    @Embedded val Ratings: ArrayList<Ratings>,
    @field:SerializedName("Metascore") val metascore: String,
    @field:SerializedName("imdbRating") val imdbrating: String,
    @field:SerializedName("imdbVotes") val imdbvotes: String,
    @field:SerializedName("imdbID") val imdbid: String,
    @field:SerializedName("Type") val type: String,
    @field:SerializedName("DVD") val dvd: String,
    @field:SerializedName("BoxOffice") val boxoffice: String,
    @field:SerializedName("Production") val production: String,
    @field:SerializedName("Website") val website: String,
    @field:SerializedName("Response") val response: String
)