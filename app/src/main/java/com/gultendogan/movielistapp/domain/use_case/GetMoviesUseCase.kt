package com.gultendogan.movielistapp.domain.use_case

import com.gultendogan.movielistapp.common.Resource
import com.gultendogan.movielistapp.data.remote.dto.Results
import com.gultendogan.movielistapp.data.remote.dto.toMovies
import com.gultendogan.movielistapp.domain.model.Movies
import com.gultendogan.movielistapp.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor (private val repository:MovieRepository){
    operator fun invoke() : Flow<Resource<List<Movies>>> = flow {
        try {
            emit(Resource.Loading<List<Movies>>())
            val movies: MutableList<Results> = mutableListOf()
            movies.addAll(repository.getAllMovies().results.filter {
                val background = "https://image.tmdb.org/t/p/w342/" + it.backdrop_path
                background != null
            })
            emit(Resource.Success<List<Movies>>(movies.map { it.toMovies() }))
        }catch (e: HttpException){
            emit(Resource.Error<List<Movies>>(e.localizedMessage ?: "An unexpected error occured"))
        }catch (e: IOException){
            emit(Resource.Error<List<Movies>>("Couldn't reach server check your internet connection"))
        }
    }
}