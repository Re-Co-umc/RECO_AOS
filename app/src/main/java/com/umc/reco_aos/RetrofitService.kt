package com.umc.reco_aos

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {
    companion object {
        //통신할 서버 url
        private const val baseUrl = "https://www.reco.p-e.kr"

        //Retrofit 객체 초기화
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(this.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val test: TestService = retrofit.create(TestService::class.java)
    }
}