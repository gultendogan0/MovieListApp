package com.gultendogan.movielistapp.presentation.fragment.movie_list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gultendogan.movielistapp.databinding.CustomMovieItemBinding
import com.gultendogan.movielistapp.domain.model.Movies

class MoviesAdapter: RecyclerView.Adapter<MoviesViewHolder>() {
    private var moviesList = emptyList<Movies>()
    var onItemClick: ((Movies) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val binding = CustomMovieItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MoviesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.bind(moviesList[position], onItemClick)
    }

    override fun getItemCount() = moviesList.size

    fun setList(moviesList: List<Movies>){
        this.moviesList = moviesList
    }
}