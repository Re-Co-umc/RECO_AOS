package com.umc.reco_aos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.umc.reco_aos.databinding.ActivityMainBinding
import com.umc.reco_aos.home.HomeFragment
import com.umc.reco_aos.mypage.MyPageFragment
import com.umc.reco_aos.tree.TreeFragment

class MainActivity : AppCompatActivity() {
    // ViewBinding Setting
    lateinit var binding: ActivityMainBinding

    // NavController 선언
    private lateinit var navController: NavController

    //private lateinit var fragment: DetailFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // NavController 설정
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        // Navigation Graph를 사용해서 Bottom Navigation 설정
        binding.navBottom.setupWithNavController(navController)

        // 아이콘에 색상 입히지 않고 아이콘 이미지 그대로 보여주기
        binding.navBottom.itemIconTintList = null

        // 최상위 화면을 제외하고는 BottomNavigation Bar 없애기
        setBottomNavigation()

        /*supportFragmentManager.beginTransaction().replace(binding.navHostFragment.id, HomeFragment()).commit()
        // navigationBottomView 등록: 하단바 fragment id(bottom_navigation) 등록
        transitionNavigationBottomView(binding.navBottom, supportFragmentManager)*/

        binding.menuTree.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(binding.navHostFragment.id, TreeFragment()).commit()
        }
    }

    private fun setBottomNavigation() {
        navController.addOnDestinationChangedListener{_, destination, _ ->
            if(destination.id == R.id.menu_home ||
                destination.id == R.id.menu_tree ||
                destination.id == R.id.menu_mypage) {
                binding.navBottom.visibility = View.VISIBLE
            } else {
                binding.navBottom.visibility = View.GONE
            }
        }
    }

    // NavigationBottomView 화면 전환하는 함수.
    private fun transitionNavigationBottomView(bottomView: BottomNavigationView, fragmentManager: FragmentManager){
        bottomView.setOnItemSelectedListener {
            it.isChecked = true
            when(it.itemId){
                R.id.menu_home -> {
                    fragmentManager.beginTransaction().replace(binding.navHostFragment.id, HomeFragment()).commit()
                }
                R.id.menu_tree -> {
                    fragmentManager.beginTransaction().replace(binding.navHostFragment.id, TreeFragment()).commit()
                }
                R.id.menu_mypage -> {
                    fragmentManager.beginTransaction().replace(binding.navHostFragment.id, MyPageFragment()).commit()
                }
                else -> Log.d("test", "error") == 0
            }
            Log.d("test", "final") == 0
        }
    }

    // 메인 화면(=하단바로 바로 들어가지는 페이지)들에서 이전 버튼 2번 누르면 앱 종료
    var waitTime = 0L
    override fun onBackPressed() {
        if(navController.currentDestination?.id == R.id.menu_home ||
            navController.currentDestination?.id == R.id.menu_tree ||
            navController.currentDestination?.id == R.id.menu_mypage) {
            if (System.currentTimeMillis() - waitTime >= 1500) {
                waitTime = System.currentTimeMillis()
                Toast.makeText(this, getString(R.string.toast_back_main_page), Toast.LENGTH_SHORT).show()
            } else {
                finish() // 액티비티 종료
            }
        }
        else{
            super.onBackPressed()
        }
    }
}
