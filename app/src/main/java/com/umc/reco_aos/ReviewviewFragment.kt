package com.umc.reco_aos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.umc.reco_aos.databinding.FragmentDetailviewBinding
import com.umc.reco_aos.databinding.FragmentReviewviewBinding


class ReviewviewFragment : Fragment() {
    //view&databinding
    private lateinit var binding: FragmentReviewviewBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentReviewviewBinding.inflate(inflater,container,false)

        // Inflate the layout for this fragment
        return binding.root
    }

}