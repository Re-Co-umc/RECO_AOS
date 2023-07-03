package com.umc.reco_aos

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter


class DetailFragmentAdapter(fragment: DetailFragment): FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->DetailviewFragment()
            else->ReviewviewFragment()
        }
    }



//    override fun getPageTitle(position: Int): CharSequence {
//        return titleList.get(position)
//    }
//
//    override fun getItem(position: Int): Fragment {
//        return fragmentList.get(position)
//    }
//    override fun getCount(): Int {
//        return fragmentList.size
//    }
//
//    fun addFragment(fragment: Fragment) {
//        fragmentList.add(fragment)
//    }

}