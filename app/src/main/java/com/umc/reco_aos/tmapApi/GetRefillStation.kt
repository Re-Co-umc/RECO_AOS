package com.umc.reco_aos.tmapApi

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

// T-map Service Key
private val TMAP_SERVICE_KEY = "TvgSIt2YIV40wmWE6sgoz190w6oRRFK064xqIYKI"
interface GetRefillStation {
    @GET("/tmap/pois")
    fun getRefillStation(
        @Header("appKey") appKey: String = TMAP_SERVICE_KEY,
        @Query("version") version: String = "1",
        @Query("searchKeyword") searchKeyword: String = "리필스테이션",
        @Query("centerLat") centerLat: Float = 37.5063362F, // 중심 위도
        @Query("centerLon") centerLon: Float = 127.0227773F, // 중심 경도
        @Query("radius") radius: Int = 0, // 검색 반경 (0: 전국)
        @Query("count") count: Int = 5, // 검색 결과 갯수
        @Query("searchtypCd") searchtypCd: String = "R" // 검색결과 정렬 기준 (R: 거리순)
    ): Call<RefillResponse>
}