package com.gultendogan.movielistapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movies (
    val backdrop_path : String?,
    val id : Int?,
    val original_language : String?,
    val original_title : String?,
    val overview : String?,
    val poster_path : String?,
    val release_date : String?,
    val title : String?,
    val vote_average : Double?
) : Parcelable