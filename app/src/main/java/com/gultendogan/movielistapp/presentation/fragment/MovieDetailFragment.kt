package com.gultendogan.movielistapp.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.animation.defaultDecayAnimationSpec
import androidx.fragment.app.viewModels
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.gultendogan.movielistapp.R
import com.gultendogan.movielistapp.databinding.FragmentMovieDetailBinding
import com.gultendogan.movielistapp.presentation.bindingadapter.BindingFragment

class MovieDetailFragment : BindingFragment<FragmentMovieDetailBinding>() {
    override val bindingInflater: (LayoutInflater) -> ViewBinding
        get() = FragmentMovieDetailBinding::inflate

    private val viewModel: MovieDetailViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val state = viewModel.state

        if (state.value.error == ""){
            val movie = state.value.movies
            movie?.let {
                binding.apply {
                    detailMovieName.text = it.title
                    detailTitle.text = it.original_title
                    detailLanguageText.text = it.original_language
                    detailDateText.text = it.release_date
                    detailVoteText.text = it.vote_average.toString()
                    detailOverviewText.text = it.overview

                    Glide.with(detailImageFullPortrait)
                        .load("https://image.tmdb.org/t/p/w342/"+it.backdrop_path)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(detailImageFullPortrait)
                }
            }
        }
    }

}