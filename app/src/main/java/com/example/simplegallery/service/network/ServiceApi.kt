package com.example.simplegallery.service.network

import com.example.simplegallery.service.model.ImageModel
import com.example.simplegallery.service.model.SearchModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ServiceApi {

    @Headers("Authorization: Client-ID "+ RetrofitInstance.API_KEY)
    @GET("photos")
    fun getGalleryImage(
        @Query("page") page : Int,
        @Query("per_page") perPage : Int,
    ) : Call<List<ImageModel>>

}