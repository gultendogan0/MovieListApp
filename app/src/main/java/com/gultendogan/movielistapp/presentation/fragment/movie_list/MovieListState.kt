package com.gultendogan.movielistapp.presentation.fragment.movie_list

import com.gultendogan.movielistapp.domain.model.Movies

data class MovieListState (
    val isLoading: Boolean? = false,
    val movies: List<Movies>? = emptyList(),
    val error: String = ""
    )