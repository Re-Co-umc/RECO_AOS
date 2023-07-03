package com.umc.reco_aos

import android.R
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.umc.reco_aos.databinding.ActivityMainBinding
import com.umc.reco_aos.databinding.FragmentDetailBinding


class MainActivity : AppCompatActivity() {

    private lateinit var fragment: DetailFragment
//    private lateinit var detailBinding: FragmentDetailBinding
//    private lateinit var fragmentDetail: DetailviewFragment
//    private lateinit var fragmentReview: ReviewviewFragment
//    private lateinit var detailFragmentAdapter: DetailFragmentAdapter

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fragment = DetailFragment()


        supportFragmentManager.beginTransaction()
            .add(binding.fragment.id, fragment)
            .commit()

    }


    }

