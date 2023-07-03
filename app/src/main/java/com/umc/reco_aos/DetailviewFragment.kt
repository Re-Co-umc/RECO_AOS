package com.umc.reco_aos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.umc.reco_aos.databinding.FragmentDetailBinding
import com.umc.reco_aos.databinding.FragmentDetailviewBinding


class DetailviewFragment : Fragment() {
    //view&databinding
    private lateinit var binding: FragmentDetailviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailviewBinding.inflate(inflater,container,false)

        // Inflate the layout for this fragment
        return binding.root
    }


}