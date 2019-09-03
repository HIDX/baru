package com.example.eventm.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.example.eventm.Item.ScreenItem
import com.example.eventm.R

class IntroAdapter(internal var mContext: Context, internal var mListScreen: List<ScreenItem>) : PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val inflater = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val layoutScreen = inflater.inflate(R.layout.layout_screen_intro, null)
        val imgSlide = layoutScreen.findViewById<ImageView>(R.id.img_screen_intro)
        val title = layoutScreen.findViewById<TextView>(R.id.txt_title_intro)
        val description = layoutScreen.findViewById<TextView>(R.id.txt_description_intro)

        title.setText(mListScreen[position].title)
        description.setText(mListScreen[position].description)
        imgSlide.setImageResource(mListScreen[position].screenImg)

        container.addView(layoutScreen)
        return layoutScreen
    }

    override fun getCount(): Int {
        return mListScreen.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {

        container.removeView(`object` as View)
    }
}
