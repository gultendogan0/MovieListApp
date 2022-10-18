package com.gultendogan.movielistapp.presentation.fragment.movie_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gultendogan.movielistapp.common.Resource
import com.gultendogan.movielistapp.domain.use_case.GetMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase
) : ViewModel(){
    private val _state = MutableStateFlow(MovieListState())
    val state: StateFlow<MovieListState> = _state

    init {
        getMovies()
    }

    private fun getMovies(){
        getMoviesUseCase().onEach { result->
            when(result){
                is Resource.Success -> {
                    _state.value = MovieListState(movies = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = MovieListState(
                        error = result.message ?:
                    "An unexpected error occured.")
                }
                is Resource.Loading -> {
                    _state.value = MovieListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}