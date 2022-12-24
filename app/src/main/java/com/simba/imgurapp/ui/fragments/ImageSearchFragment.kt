package com.simba.imgurapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.simba.imgurapp.databinding.LayoutImageSearchBinding

class ImageSearchFragment : Fragment() {

    private lateinit var binding: LayoutImageSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = LayoutImageSearchBinding.inflate(inflater, container, false)
        return binding.root
    }
}