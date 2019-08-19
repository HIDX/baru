package com.example.eventm.Holder

import android.content.Context

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.eventm.R
import kotlinx.android.synthetic.main.cardview_home.view.*

class HolderSlideHome(itemView:View,private val mContex:Context):RecyclerView.ViewHolder(itemView){

    private val Iview :ImageView
    private val Tview :TextView

    init {
        Iview =itemView.findViewById<View>(R.id.img_slide_home) as ImageView
        Tview =itemView.findViewById<View>(R.id.title_slide) as TextView
    }

    fun index (item:Int, s:String){
        Glide.with(mContex).load(item).into(Iview)
        Tview.text =s
    }

}