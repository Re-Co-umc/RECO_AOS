package com.umc.reco_aos.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}