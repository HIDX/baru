package com.example.eventm.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.eventm.Holder.HolderSlideHome
import com.example.eventm.R

 class SliderHomeAdapter (private val ImageH:IntArray,private val name: Array<String>,private val mContext:Context):RecyclerView.Adapter<HolderSlideHome>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderSlideHome {
        val v =LayoutInflater.from(parent.context).inflate(R.layout.cardview_home,parent,false)
        return HolderSlideHome(v,mContext)

    }

    override fun onBindViewHolder(holder: HolderSlideHome, position: Int) {
        holder.index(ImageH[position],name[position])
    }

    override fun getItemCount(): Int {
        return ImageH.size // return sebanyak size nya
    }

}

