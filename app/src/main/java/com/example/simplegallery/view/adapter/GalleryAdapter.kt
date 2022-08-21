package com.example.simplegallery.view.adapter

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.simplegallery.R
import com.example.simplegallery.databinding.GalleryRowItemBinding
import com.example.simplegallery.service.model.ImageModel

class GalleryAdapter : ListAdapter<ImageModel,GalleryAdapter.GalleryViewHolder>(GalleryDiffUtil()) {

    class GalleryViewHolder(private val binding: GalleryRowItemBinding) :
        RecyclerView.ViewHolder(binding.root){

        fun bind(imageModel: ImageModel){
            Glide.with(itemView)
                .load(imageModel.urls.regular)
                .centerCrop()
                .into(binding.galleryRowIV)
        }


    }

    class GalleryDiffUtil : DiffUtil.ItemCallback<ImageModel>() {
        override fun areItemsTheSame(oldItem: ImageModel, newItem: ImageModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ImageModel, newItem: ImageModel): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        val binding = GalleryRowItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return GalleryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        var imageData = getItem(position)
        holder.bind(imageData)
        holder.itemView.setOnClickListener {
            var bundle = Bundle()
            bundle.putString("urls",imageData.urls.regular)
            Navigation.findNavController(holder.itemView).navigate(R.id.action_galleryFragment_to_viewPhotoFragment,bundle)
        }

    }
}