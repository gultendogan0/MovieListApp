package com.gultendogan.movielistapp.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.gultendogan.movielistapp.R
import com.gultendogan.movielistapp.databinding.FragmentMovieDetailBinding
import com.gultendogan.movielistapp.presentation.bindingadapter.BindingFragment

class MovieDetailFragment : BindingFragment<FragmentMovieDetailBinding>(){
    override val bindingInflater: (LayoutInflater) -> ViewBinding
        get() = FragmentMovieDetailBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}