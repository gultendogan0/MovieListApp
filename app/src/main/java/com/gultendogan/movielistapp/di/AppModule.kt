package com.gultendogan.movielistapp.di

import com.gultendogan.movielistapp.common.Constants
import com.gultendogan.movielistapp.data.remote.MovieApi
import com.gultendogan.movielistapp.data.repository.MovieRepositoryImpl
import com.gultendogan.movielistapp.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMovieApi():MovieApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieApi::class.java)
    }

    @Provides
    @Singleton
    fun provideMovieRepository(api: MovieApi): MovieRepository{
        return MovieRepositoryImpl(api)
    }
}