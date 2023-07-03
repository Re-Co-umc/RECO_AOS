package com.umc.reco_aos.home

import android.graphics.Bitmap.createScaledBitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.skt.Tmap.TMapMarkerItem
import com.skt.Tmap.TMapPoint
import com.skt.Tmap.TMapView
import com.umc.reco_aos.R
import com.umc.reco_aos.databinding.FragmentHomeBinding


// 홈: 지도
class HomeFragment : Fragment() {
    // ViewBinding Setting
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    // T-map Service Key
    private val TMAP_SERVICE_KEY = "TvgSIt2YIV40wmWE6sgoz190w6oRRFK064xqIYKI"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 지도: T-map
        val tmapview = TMapView(context)
        tmapview.setSKTMapApiKey(TMAP_SERVICE_KEY)
        binding.linearMap.addView(tmapview)

        // 현재 위치 좌표
        val currentPinMarker = TMapMarkerItem()
        val currentPinPoint = TMapPoint(37.5063362, 127.0227773) // 현위치

        // 마커 아이콘
        var currentPinBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_map_current_pin)
        currentPinBitmap = createScaledBitmap(currentPinBitmap, 30, 30, true)

        currentPinMarker.icon = currentPinBitmap // 마커 아이콘 지정
        currentPinMarker.setPosition(0.5f, 0.5f) // 마커의 중심점을 수직, 수평 모두 중앙으로 지정
        currentPinMarker.tMapPoint = currentPinPoint // 마커의 좌표 지정
        currentPinMarker.name = "현위치" // 마커의 타이틀 지정

        tmapview.addMarkerItem("currentPinMarker", currentPinMarker) // 지도에 마커 추가
        tmapview.setCenterPoint(127.0227773, 37.5063362)

        // 가까운 리필스테이션 목록
        val bottomSheet = RefillListFragment()
        bottomSheet.show(requireActivity().supportFragmentManager, bottomSheet.tag)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}