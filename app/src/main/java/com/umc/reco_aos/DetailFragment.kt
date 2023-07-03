package com.umc.reco_aos

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.umc.reco_aos.databinding.DialogRefillBinding
import com.umc.reco_aos.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    //view&databinding
    private lateinit var binding: FragmentDetailBinding
    private lateinit var checkBox: CheckBox
    private lateinit var refillBtn: Button
    private lateinit var adapter: DetailFragmentAdapter
    private lateinit var refillBinding: DialogRefillBinding

    private val text = listOf("상세정보","리뷰")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater,container,false)
        refillBinding = DialogRefillBinding.inflate(inflater,container,false)
        checkBox = binding.checkbox
        checkBox.setButtonDrawable(R.drawable.btn_bookmark)
        refillBtn = binding.refillBtn
        refillBtn.setOnClickListener {
            var dialog = context?.let { it1 -> RefillDialog(it1) }
            if (dialog != null) {
                dialog.show()
            }
        }
        binding.viewPager.adapter=DetailFragmentAdapter(this)
        TabLayoutMediator(binding.tabLayout, binding.viewPager){
            tab, pos ->
            tab.text = text[pos]
        }.attach()

//        tabLayout = binding.tabLayout
       // Inflate the layout for this fragment
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }



//
//    fun setUpViewPager(viewPager: ViewPager){
//        adapter = DetailFragmentAdapter(requireActivity())
//        adapter.addFragment(DetailviewFragment(),)
//        adapter.addFragment(ReviewviewFragment(), "review")
//
//        viewPager.adapter = adapter
//    }
}