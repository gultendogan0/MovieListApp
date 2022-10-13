package com.gultendogan.movielistapp.data.remote

import com.gultendogan.movielistapp.data.remote.dto.MovieDto
import retrofit2.http.GET

interface MovieApi {

    @GET("3/movie/popular?api_key=802b2c4b88ea1183e50e6b285a27696e")
    suspend fun getAllMovie() : MovieDto


}