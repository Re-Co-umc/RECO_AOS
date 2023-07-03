package com.umc.reco_aos.tmapApi

import com.google.gson.annotations.SerializedName

data class RefillResponse(
    @SerializedName("searchPoiInfo")
    val searchPoiInfo: SearchPoiInfo,
)

data class SearchPoiInfo(
    @SerializedName("totalCount")
    val totalCount: String,

    @SerializedName("count")
    val count: String,

    @SerializedName("page")
    val page: String,

    @SerializedName("pois")
    val pois: Pois,
)

data class Pois(
    @SerializedName("poi")
    var poi: MutableList<Object>? = null
)
