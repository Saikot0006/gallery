package com.example.simplegallery.view.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simplegallery.R
import com.example.simplegallery.databinding.FragmentGalleryBinding
import com.example.simplegallery.service.model.ImageModel
import com.example.simplegallery.service.network.RetrofitInstance
import com.example.simplegallery.service.repository.GalleryRepository
import com.example.simplegallery.view.adapter.GalleryAdapter
import com.example.simplegallery.viewmodel.GalleryViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class GalleryFragment : Fragment() {

    lateinit var binding : FragmentGalleryBinding
    private var page = 1
    private lateinit var galleryAdapter: GalleryAdapter
    lateinit var imageList : ArrayList<ImageModel>
    private  val viewModel : GalleryViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentGalleryBinding.inflate(inflater,container,false)
        galleryAdapter = GalleryAdapter()
        imageList = ArrayList<ImageModel>()
        binding.galleryRV.apply {
            layoutManager = GridLayoutManager(requireActivity(),3)
            adapter = galleryAdapter
        }

        viewModel.getGalleryImageList().observe(viewLifecycleOwner){
            galleryAdapter.submitList(it)
        }

        return binding.root
    }


}