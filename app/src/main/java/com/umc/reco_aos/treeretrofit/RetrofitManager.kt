//package com.umc.reco_aos.treeretrofit
//
//import android.util.Log
//import com.google.gson.JsonElement
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
//
//class RetrofitManager {
//
//    companion object {
//        val instance = RetrofitManager()
//    }
//    //레트로핏 인터페이스 가져오기
//    private val iRetrofit:IRetrofit? = RetrofitClient.getClient()?.create(IRetrofit::class.java)
//     //api 호출
//    fun searchPhotos(searchTerm: String?, completion:(String) -> Unit){
//        val call = iRetrofit?.getcompany().let{
//            it
//        }?:return
//
//         call.enqueue(object : Callback<Results?> {
//             override fun onResponse(call: Call<Results?>, response: Response<Results?>) {
//                 Log.d("server","RetrofitManager - onResponse() called / resonse : ${response.body()}")
//                 completion(response.raw().toString())             }
//
//             override fun onFailure(call: Call<Results?>, t: Throwable) {
//                 Log.d("server","RetrofitManager - onFailure() called / t:st")
//             }
//
//         })
//    }
//}