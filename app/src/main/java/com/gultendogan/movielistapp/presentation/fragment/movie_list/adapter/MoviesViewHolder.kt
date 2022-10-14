package com.gultendogan.movielistapp.presentation.fragment.movie_list.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.gultendogan.movielistapp.databinding.CustomMovieItemBinding
import com.gultendogan.movielistapp.domain.model.Movies

class MoviesViewHolder(private val binding: CustomMovieItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(movies: Movies, onItemClick: ((Movies) -> Unit)?) {
        Glide.with(binding.root)
            .load("https://image.tmdb.org/t/p/w342/" + movies.poster_path)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(binding.movieBackground)
    }

}
