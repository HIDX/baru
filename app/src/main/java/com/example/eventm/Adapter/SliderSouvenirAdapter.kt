package com.example.eventm.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.eventm.Holder.HolderSlideHome
import com.example.eventm.Holder.HolderSouvenir
import com.example.eventm.R

class SliderSouvenirAdapter (private val ImageS:IntArray,private val name: Array<String>,private val mContext: Context): RecyclerView.Adapter<HolderSouvenir>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderSouvenir {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.cardview_souvenir,parent,false)
        return HolderSouvenir(v,mContext)
    }

    override fun getItemCount(): Int {
        return ImageS.size
    }

    override fun onBindViewHolder(holder: HolderSouvenir, position: Int) {
        holder.index(ImageS[position],name[position])
    }

}