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
import com.umc.reco_aos.DetailFragment
import com.umc.reco_aos.R
import com.umc.reco_aos.TreeFragment
import com.umc.reco_aos.databinding.FragmentHomeBinding
import com.umc.reco_aos.tmapApi.getRefillStation


// 홈: 지도
class HomeFragment : Fragment() {
    // ViewBinding Setting
    lateinit var binding: FragmentHomeBinding

    // T-map Service Key
    private val TMAP_SERVICE_KEY = "TvgSIt2YIV40wmWE6sgoz190w6oRRFK064xqIYKI"

    private var bookmarkChecked = false

    private var tmapview: TMapView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 지도: T-map
        tmapview = TMapView(context)
        tmapview!!.setSKTMapApiKey(TMAP_SERVICE_KEY)
        binding.linearMap.addView(tmapview)

        // 현재 위치 좌표
        val currentPinMarker = TMapMarkerItem()
        val currentPinPoint = TMapPoint(37.5063362, 127.0227773) // 현위치

        // 마커 아이콘
        var currentPinBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_map_current_pin)
        currentPinBitmap = createScaledBitmap(currentPinBitmap, 50, 50, true)

        currentPinMarker.icon = currentPinBitmap // 마커 아이콘 지정
        currentPinMarker.setPosition(0.5f, 0.5f) // 마커의 중심점을 수직, 수평 모두 중앙으로 지정
        currentPinMarker.tMapPoint = currentPinPoint // 마커의 좌표 지정
        currentPinMarker.name = "현위치" // 마커의 타이틀 지정

        tmapview!!.addMarkerItem("currentPinMarker", currentPinMarker) // 지도에 마커 추가

        // 중앙 좌표
        tmapview!!.setCenterPoint(127.0227773, 37.5063362)

        getRefillStation(
            setRefillStation = {
                setRefillStation(it)
            }
        )

        // 리필스테이션 찜
        binding.btnRefillBookmark.setOnClickListener {
            bookmarkChecked = !bookmarkChecked
            if(bookmarkChecked) {
                val iconResourceName = "ic_bookmark_selected"
                val iconResourceId = resources.getIdentifier(iconResourceName, "drawable", requireContext().packageName)
                binding.btnRefillBookmark.setImageResource(iconResourceId)
            }
            else {
                val iconResourceName = "ic_bookmark_unselected"
                val iconResourceId = resources.getIdentifier(iconResourceName, "drawable", requireContext().packageName)
                binding.btnRefillBookmark.setImageResource(iconResourceId)
            }
        }

        // 리필스테이션 세부
        binding.textShopName.setOnClickListener(View.OnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().add(R.id.nav_host_fragment, DetailFragment()).commit()
        })
    }

    // 리필스테이션 세팅
    fun setRefillStation(refillStation: MutableList<RefillStationData>) {
        if(refillStation.size > 0) {
            // 가장 가까운 리필 스테이션
            binding.textShopName.text = refillStation[0].placeName
            binding.textShopAddress.text = refillStation[0].address

            /*for(refill in refillStation) {
                // 현재 위치 좌표
                val refillPinMarker = TMapMarkerItem()
                val refillPinPoint = TMapPoint(refill.latitude, refill.longitude) // 현위치

                // 마커 아이콘
                var refillPinBitmap =
                    BitmapFactory.decodeResource(getResources(), R.drawable.ic_map_refill_pin)
                //refillPinBitmap = createScaledBitmap(refillPinBitmap, 100, 100, true)

                refillPinMarker.icon = refillPinBitmap // 마커 아이콘 지정
                refillPinMarker.setPosition(0.5f, 0.5f) // 마커의 중심점을 수직 중앙, 수평 하단으로 지정
                refillPinMarker.tMapPoint = refillPinPoint // 마커의 좌표 지정
                refillPinMarker.name = "리필스테이션" // 마커의 타이틀 지정

                tmapview!!.addMarkerItem("refillPinMarker", refillPinMarker) // 지도에 마커 추가
            }*/
        }
    }
}