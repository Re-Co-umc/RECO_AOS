package com.umc.reco_aos

import android.app.AlertDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.umc.reco_aos.databinding.FragmentTreeBinding
//import com.umc.reco_aos.treeretrofit.IRetrofit
//import com.umc.reco_aos.treeretrofit.Results
//import com.umc.reco_aos.treeretrofit.result
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class TreeFragment : Fragment() {
    lateinit var textView: TextView
    lateinit var categoryAdapter: CategoryAdapter
    lateinit var shopAdapter: ShopAdapter

    val categorydata = mutableListOf<CategoryData>()
    val shopdata = mutableListOf<ShopData>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        val binding = FragmentTreeBinding.inflate(inflater,container, false)

        binding.infoBtn.setOnClickListener{
            //Dialog 만들기
            val mDialogView = LayoutInflater.from(context).inflate(R.layout.info_dialog,null)
            val mBuilder = AlertDialog.Builder(context)
                .setView(mDialogView)
                .create()
            mBuilder?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

            mBuilder?.window?.requestFeature(Window.FEATURE_NO_TITLE)
            mBuilder.show()

            mBuilder.window?.setBackgroundDrawableResource(R.drawable.dialog_shape)
            mBuilder.window?.setLayout(900, WindowManager.LayoutParams.WRAP_CONTENT)

        }


        initRecycler(binding.rvCategory,binding.rvShop)
        val dialogbinding = FragmentTreeBinding.inflate(inflater,container, false)


//        val retrofitClient = RetrofitClient.getClient()
//        val retrofitInterface = retrofitClient?.create(IRetrofit::class.java)
//
//        retrofitInterface?.searchPhotos()?.enqueue(object: Callback<Results?> {
//            override fun onResponse(call: Call<Results?>, response: Response<Results?>) {
//                Log.d("server","Success! ${response.body()?.id}")
//            }
//
//            override fun onFailure(call: Call<Results?>, t: Throwable) {
//                Log.d("server","error!",t)
//            }
//        val retrofit = Retrofit.Builder().baseUrl(API.BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create()).build();
//        val service = retrofit.create(IRetrofit::class.java);
//
//        service.getcompany()?.enqueue(object : Callback<Results>{
//            override fun onResponse(call: Call<Results>, response: Response<Results>) {
//                val jsonArray = JSONArray(response.body().toString())
//                if(response.isSuccessful){
//                    // 정상적으로 통신이 성고된 경우
//                    var result: Results? = response.body()
//                    Log.d("server", "onResponse 성공: " + result?.toString());
//                }else{
//                    // 통신이 실패한 경우(응답코드 3xx, 4xx 등)
//                    Log.d("server", "onResponse 실패")
//                }
//            }

//            override fun onFailure(call: Call<Results>, t: Throwable) {
//                // 통신 실패 (인터넷 끊킴, 예외 발생 등 시스템적인 이유)
//                Log.d("server", "onFailure 에러: " + t.message.toString());
//            }
//        })

        return binding.root
    }




    private fun initRecycler(rvCategory: RecyclerView,rvShop: RecyclerView) {
        categoryAdapter = CategoryAdapter(requireContext())
        rvCategory.adapter = categoryAdapter


        categorydata.apply {
            add(CategoryData(img = R.drawable.e_receipt, name = "전자영수증"))
            add(CategoryData(img = R.drawable.refill, name = "리필스테이션"))
            add(CategoryData(img = R.drawable.bowl, name = "다회용기"))
            add(CategoryData(img = R.drawable.eco, name = "친환경제품"))
            add(CategoryData(img = R.drawable.car, name = "무공해차"))
            add(CategoryData(img = R.drawable.cup, name = "다회용컵"))
            add(CategoryData(img = R.drawable.trash, name = "고품질 재활용품"))


            categoryAdapter.datas = categorydata
            categoryAdapter.notifyDataSetChanged()

        }

        shopAdapter = ShopAdapter(requireContext())
        rvShop.adapter = shopAdapter


        shopdata.apply {
            add(ShopData(img = R.drawable.shop_logo))
            add(ShopData(img = R.drawable.shop_logo))
            add(ShopData(img = R.drawable.shop_logo))
            add(ShopData(img = R.drawable.shop_logo))

            shopAdapter.datas = shopdata
            shopAdapter.notifyDataSetChanged()

        }

    }



}

data class CategoryData (
    val img : Int,
    val name : String,

)

data class ShopData (
    val img : Int,
)