package com.gultendogan.movielistapp.presentation.fragment.movie_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import com.gultendogan.movielistapp.R
import com.gultendogan.movielistapp.databinding.FragmentMovieListBinding
import com.gultendogan.movielistapp.presentation.bindingadapter.BindingFragment
import com.gultendogan.movielistapp.presentation.fragment.movie_list.adapter.MoviesAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MovieListFragment : BindingFragment<FragmentMovieListBinding>(){
    override val bindingInflater: (LayoutInflater) -> ViewBinding
        get() = FragmentMovieListBinding::inflate
    private val viewModel : MovieListViewModel by viewModels()
    private lateinit var adaper: MoviesAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adaper = MoviesAdapter()

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.state.collect{ movieListState->
                if (!movieListState.movies.isNullOrEmpty()){
                    adaper.setList(movieListState.movies.shuffled())
                    binding.movieListRecyclerView.visibility = View.VISIBLE
                    binding.movieListRecyclerView.adapter = adaper
                }
                if (movieListState.error != ""){
                    binding.movieListErrorText.text = movieListState.error
                }
                binding.movieListProgressBar.isVisible = movieListState.isLoading ?: false
            }
        }
    }
}