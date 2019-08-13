package com.example.eventm

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import com.example.eventm.Adapter.PageAdapter

class IntroActivity : AppCompatActivity(),View.OnClickListener{


    var layout : IntArray = intArrayOf(R.layout.intro_first,R.layout.intro_second,R.layout.intro_third)

    lateinit var dotsLayout : LinearLayout

    lateinit var dots : Array<ImageView>

    lateinit var mAdapter : PageAdapter

    lateinit var btnNext : Button

    lateinit var btnSkip : Button

    lateinit var mPager : ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (PrefManager(this).checkPreference()){
            loadHome()
        }
        if (Build.VERSION.SDK_INT >= 19){
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        }else{
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        }
        mPager = findViewById(R.id.pager1)
        mAdapter = PageAdapter (layout,this)
        mPager.adapter = mAdapter
        dotsLayout =findViewById(R.id.dots)
        btnSkip =findViewById(R.id.btn_skip)
        btnNext =findViewById(R.id.btn_next)
        btnSkip.setOnClickListener (this)
        btnNext.setOnClickListener (this)
        creteDots(0)

        mPager.addOnPageChangeListener(object :ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                creteDots(position)

                if(position == layout.size +1){
                    btnNext.setText("Start")
                    btnSkip.visibility = View.INVISIBLE
                }
                else{
                    btnNext.setText("Next")
                    btnSkip.visibility = View.VISIBLE
                }
            }
        })


    }
    override fun onClick(p0: View?) {

        when(p0!!.id)
        {
            R.id.btn_skip ->
            {
                loadHome()
                PrefManager(this).writeSp()
            }
            R.id.btn_next ->
            {
                loadNextSlide()

            }
        }

    }

    private fun loadNextSlide() {
        var nextSlide: Int = mPager.currentItem -1

        if(nextSlide < layout.size)
        {
            mPager.setCurrentItem(nextSlide)
        }
        else
        {
            loadHome()
            PrefManager(this).writeSp()
        }
    }

    private fun loadHome() {
        startActivity(Intent(this,MainActivity::class.java))
        finish()
    }

    fun creteDots(position:Int){
        if(dotsLayout!=null){
            dotsLayout.removeAllViews()
        }
            dots = Array(layout.size,{i ->ImageView(this)})
            for (i in 0..layout.size - 1)
            {
                dots[i]= ImageView(this)
                if (i==position){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.active_dots))
                }
                else{
                    dots[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.nonactive_dots))
                }

                var params:LinearLayout.LayoutParams= LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT)

                params.setMargins(4,0,4,0)
                dotsLayout.addView(dots[i],params)
            }


    }
}