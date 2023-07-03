package com.umc.reco_aos.tmapApi

import android.content.ContentValues.TAG
import android.util.Log
import com.umc.reco_aos.home.RefillStationData
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

// api 통신을 위한 retrofit
private val retrofit: Retrofit = TmapApiClient.retrofit

// 리필스테이션 리스트 조회
fun getRefillStation(
    setRefillStation: (refillStation: MutableList<RefillStationData>) -> Unit
) {
    retrofit.create(GetRefillStation::class.java)
        .getRefillStation()
        .enqueue(object : Callback<RefillResponse> {
            override fun onResponse(call: Call<RefillResponse>, response: Response<RefillResponse>) {
                Log.d(TAG, "리필스테이션 리스트 조회 결과 -------------------------------------------")
                Log.d(TAG, "onResponse: ${response.body().toString()}")

                val body: RefillResponse = response.body()!!
                val searchPoiInfo: SearchPoiInfo = body.searchPoiInfo
                val refillStations: MutableList<Object>? = searchPoiInfo.pois.poi

                if(refillStations != null) {
                    val result: MutableList<RefillStationData> = mutableListOf<RefillStationData>()

                    for(item in refillStations) {
                        Log.d("Test", "--------------------------------")
                        Log.d("Test", item.toString())
                        // 아이템 내용을 json 형태로 변환


                        /*val frontLat: Double = jsonContent.getString("frontLat").toDouble()
                        val frontLon: Double = jsonContent.getString("frontLon").toDouble()
                        val noorLat: Double = jsonContent.getString("noorLat").toDouble()
                        val noorLon: Double = jsonContent.getString("noorLon").toDouble()

                        val latitude: Double = (frontLat + noorLat) / 2.0
                        val longitude: Double = (frontLon + noorLon) / 2.0

                        val upperAddrName: String = jsonContent.getString("upperAddrName")
                        val middleAddrName: String = jsonContent.getString("middleAddrName")
                        val address: String = upperAddrName + ", " + middleAddrName

                        result.add(
                            RefillStationData(
                                jsonContent.getString("name"),
                                latitude,
                                longitude,
                                address
                            )
                        )*/

                    }

                    //setRefillStation(result)
                }

                //getAllProfile(result)
            }

            override fun onFailure(call: Call<RefillResponse>, t: Throwable) {
                Log.d(TAG, "리필스테이션 리스트 조회 결과 fail -------------------------------------------")
                Log.e(TAG, "onFailure: ${t.message}")
            }
        })
}