package com.example.simplegallery.service.repository

import android.app.ProgressDialog
import android.content.Context
import android.util.Log
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.simplegallery.service.model.ImageModel
import com.example.simplegallery.service.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GalleryRepository {

    var mLiveData : MutableLiveData<List<ImageModel>>?  = null

    fun getGalleryImage() : MutableLiveData<List<ImageModel>>{

        if(mLiveData==null){
            mLiveData = MutableLiveData()
        }

        RetrofitInstance.getRetrofitInstance().getGalleryImage(1,30)
            .enqueue(object : Callback<List<ImageModel>> {
                override fun onResponse(
                    call: Call<List<ImageModel>>,
                    response: Response<List<ImageModel>>
                ) {
                    if(response.isSuccessful){

                        Log.e("size", "onResponse: "+response.body()?.size )
                        mLiveData?.postValue(response.body()!!)

                    }

                }

                override fun onFailure(call: Call<List<ImageModel>>, t: Throwable) {
                    Log.e("onFailure", "onFailure: "+t.localizedMessage )
                }
            })

        return mLiveData!!
    }
}