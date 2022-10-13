package com.gultendogan.movielistapp.domain.repository

import com.gultendogan.movielistapp.data.remote.dto.MovieDto

interface MovieRepository {
    suspend fun getAllMovies() :MovieDto
}