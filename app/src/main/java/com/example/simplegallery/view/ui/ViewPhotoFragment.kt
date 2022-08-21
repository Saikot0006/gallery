package com.example.simplegallery.view.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.simplegallery.R
import com.example.simplegallery.databinding.FragmentViewPhotoBinding
import com.example.simplegallery.service.model.ImageModel


class ViewPhotoFragment : Fragment() {

    lateinit var binding : FragmentViewPhotoBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentViewPhotoBinding.inflate(inflater,container,false)
        var url = arguments?.getString("urls")
        Log.e("url", "onCreateView: "+url )
        Glide.with(requireActivity())
            .load(url)
            .centerCrop()
            .into(binding.viewPhotoIV)
        return binding.root
    }


}