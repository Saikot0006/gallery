package com.example.simplegallery.service.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitInstance {

    //https://api.unsplash.com/search/photos/?client_id=x3t8TzU2-vJhJVHX0J0f1OqCwmkcxNA8NHl7AFfy2W8&query=india
    companion object {
        const val BASE_URL = "https://api.unsplash.com/"
        const val API_KEY = "x3t8TzU2-vJhJVHX0J0f1OqCwmkcxNA8NHl7AFfy2W8"
        var retrofit : Retrofit? = null

        fun getRetrofitInstance() : ServiceApi {
            if(retrofit==null){
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!.create(ServiceApi::class.java)
        }


    }
}