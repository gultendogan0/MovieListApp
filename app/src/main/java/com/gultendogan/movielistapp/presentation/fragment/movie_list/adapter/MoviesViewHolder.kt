package com.gultendogan.movielistapp.presentation.fragment.movie_list.adapter

import android.graphics.drawable.Drawable
import android.graphics.drawable.DrawableWrapper
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.gultendogan.movielistapp.databinding.CustomMovieItemBinding
import com.gultendogan.movielistapp.domain.model.Movies

class MoviesViewHolder(private val binding: CustomMovieItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(movies: Movies, onItemClick: ((Movies) -> Unit)?) {

        Glide.with(binding.root)
            .load("https://image.tmdb.org/t/p/w342/" + movies.poster_path)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(binding.movieBackground)

        binding.root.setOnClickListener {
            onItemClick?.invoke(movies)
        }

    }

}

