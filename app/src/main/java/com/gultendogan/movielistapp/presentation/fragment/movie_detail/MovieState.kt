package com.gultendogan.movielistapp.presentation.fragment.movie_detail

import com.gultendogan.movielistapp.domain.model.Movies

data class MovieState(
    val movies: Movies? = null,
    val error: String = ""
)