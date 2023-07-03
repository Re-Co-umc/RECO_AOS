package com.umc.reco_aos.tmapApi

import retrofit2.Call
import retrofit2.http.GET

interface GetRefillStation {
    @GET("/tmap/pois")
    fun getRefillStation(
        //@Body params: AddProfileRequest,
        //@Path("profileId") profileId: Int
    ): Call<String>
}