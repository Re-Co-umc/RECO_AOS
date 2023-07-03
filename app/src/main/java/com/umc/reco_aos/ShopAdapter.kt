package com.umc.reco_aos

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ShopAdapter(private val context: Context) : RecyclerView.Adapter<ShopAdapter.ViewHolder>() {
    var datas = mutableListOf<ShopData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_shop,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datas[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val imgProfile: ImageView = itemView.findViewById(R.id.shop_img)

        fun bind(item: ShopData) {
            Glide.with(itemView).load(item.img).into(imgProfile)

        }
    }

}