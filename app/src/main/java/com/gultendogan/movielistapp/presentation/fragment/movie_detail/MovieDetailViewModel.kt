package com.gultendogan.movielistapp.presentation.fragment.movie_detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.gultendogan.movielistapp.common.Constants
import com.gultendogan.movielistapp.domain.model.Movies
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class MovieDetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = MutableStateFlow(MovieState())
    val state: StateFlow<MovieState> = _state

    init {
        savedStateHandle.get<Movies>(Constants.MOVIE_ID)?.let { movie ->
            getMovieDetail(movie)
        }
    }

    private fun getMovieDetail(movie:Movies){
        if(!movie.overview.isNullOrEmpty()){
            _state.value = MovieState(movies = movie)
        }else{
            _state.value = MovieState(error = "Hata!")
        }
    }
}