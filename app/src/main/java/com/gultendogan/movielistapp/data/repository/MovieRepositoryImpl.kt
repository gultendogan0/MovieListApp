package com.gultendogan.movielistapp.data.repository

import com.gultendogan.movielistapp.data.remote.MovieApi
import com.gultendogan.movielistapp.data.remote.dto.MovieDto
import com.gultendogan.movielistapp.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val api: MovieApi
): MovieRepository {
    override suspend fun getAllMovies(): MovieDto {
        return api.getAllMovie()
    }
}