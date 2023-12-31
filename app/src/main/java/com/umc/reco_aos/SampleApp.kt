package com.umc.reco_aos

import android.app.Application
import com.kakao.sdk.common.KakaoSdk
import com.umc.reco_aos.R

class SampleApp : Application() {
    override fun onCreate() {
        super.onCreate()
        //1. 앱초기화 시점에 카카오 sdk 초기화
        KakaoSdk.init(this, getString(R.string.kakao_native_app_key))
        //2. manifest 파일에 등록
    }
}