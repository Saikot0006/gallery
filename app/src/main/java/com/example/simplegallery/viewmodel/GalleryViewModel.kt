package com.example.simplegallery.viewmodel

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.simplegallery.service.model.ImageModel
import com.example.simplegallery.service.repository.GalleryRepository

class GalleryViewModel : ViewModel()  {

    private lateinit var repository: GalleryRepository

    init {
        repository = GalleryRepository()
    }

    fun getGalleryImageList() : LiveData<List<ImageModel>> = repository.getGalleryImage()

}