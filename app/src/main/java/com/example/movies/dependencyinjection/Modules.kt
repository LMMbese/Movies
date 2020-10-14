package com.example.movies.dependencyinjection

import androidx.room.Room
import com.example.movies.api.ApiClient
import com.example.movies.constants.BASE_URL
import com.example.movies.data.AppDatabase
import com.example.movies.movies.repository.MovieRepository
import com.example.movies.movies.service.GetMovieService
import com.example.movies.movies.viewmodel.MovieViewModel
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val viewModelModule = module {
    viewModel {
        MovieViewModel(get())
    }
}

val repoModule = module {
    single {
        MovieRepository(get(), get())
    }
}

val apiModule = module {
    fun provideApi(retrofit: Retrofit): ApiClient {
        return retrofit.create(ApiClient::class.java)
    }

    single { provideApi(get()) }
}

val persistenceModule = module {
    single {
        Room.databaseBuilder(get(), AppDatabase::class.java, "movie.db").build()
    }
    single { get<AppDatabase>().movieDao() }
}

val retrofitModule = module {
    fun retrofit(baseUrl: String) = Retrofit.Builder()
        .callFactory(OkHttpClient.Builder().build())
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun okHttp() = OkHttpClient.Builder()
        .build()

    single {
        okHttp()
    }
    single {
        retrofit(BASE_URL)
    }
    single {
        get<Retrofit>().create(GetMovieService::class.java)
    }
}
