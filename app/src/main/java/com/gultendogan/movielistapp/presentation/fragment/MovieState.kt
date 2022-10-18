package com.gultendogan.movielistapp.presentation.fragment

import com.gultendogan.movielistapp.domain.model.Movies

data class MovieState(
    val movies: Movies? = null,
    val error: String = ""
)