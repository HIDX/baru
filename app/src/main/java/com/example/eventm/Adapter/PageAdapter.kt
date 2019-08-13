package com.example.eventm.Adapter

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter

class PageAdapter : PagerAdapter {// impor pager yg ada di widget

    lateinit var layouts: IntArray

    lateinit var inflater:LayoutInflater

    lateinit var con :Context

    constructor(Layouts: IntArray, con: Context) : super() {
        this.layouts = Layouts
        this.con = con
        inflater = con.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }


    override fun isViewFromObject(view: View, `object`: Any): Boolean {

        return view == `object`

    }

    override fun getCount(): Int {
        return layouts.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        var view:View = inflater.inflate(layouts[position],container,false)
        container.addView(view)
        return view

    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        var view:View = `object` as View
        container!!.removeView(view)

    }

}
