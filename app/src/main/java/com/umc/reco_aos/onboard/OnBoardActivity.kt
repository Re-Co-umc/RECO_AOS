package com.umc.reco_aos.onboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContentProviderCompat.requireContext
import com.umc.reco_aos.MainActivity
import com.umc.reco_aos.R
import com.umc.reco_aos.databinding.ActivityOnBoardBinding

class OnBoardActivity : AppCompatActivity() {
    // ViewBinding Setting
    lateinit var binding: ActivityOnBoardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var count: Int = 1
        binding.btnOnboard.setOnClickListener {
            if(count == 4) {
                val mainActivity = Intent(this, MainActivity::class.java)
                startActivity(mainActivity)
                finish()
            }
            count++
            val iconResourceName = "img_onboarding_" + count
            val iconResourceId = resources.getIdentifier(iconResourceName, "drawable", packageName)
            binding.imgBack.setImageResource(iconResourceId)
        }
    }
}