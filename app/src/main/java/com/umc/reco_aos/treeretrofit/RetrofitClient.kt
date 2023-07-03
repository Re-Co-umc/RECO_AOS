//package com.umc.reco_aos.treeretrofit
//
//import android.util.Log
//import com.google.gson.GsonBuilder
//import com.umc.reco_aos.API
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//
//object RetrofitClient {
//    private var retrofitClient: Retrofit? =null
//
//    open fun getClient(): Retrofit?{
//        Log.d("TAG", "RetrofitClient = getClient() called")
//
//        if(retrofitClient == null){
//            retrofitClient = Retrofit.Builder()
//                .baseUrl(API.BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//        }
//        return retrofitClient
//    }
//}