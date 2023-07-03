package com.umc.reco_aos

import android.graphics.Paint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.umc.reco_aos.databinding.FragmentMypageBinding
import com.umc.reco_aos.databinding.FragmentTreeBinding

class MypageFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val binding = FragmentMypageBinding.inflate(inflater,container, false)

        binding.button5.paintFlags = Paint.UNDERLINE_TEXT_FLAG
        return binding.root
    }

}