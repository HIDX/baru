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
import com.example.eventm.Adapter.mPagerAdapter

class WelcomeActivity : AppCompatActivity(), View.OnClickListener {
    // private untuk pembuatan slider
    private var mPager: ViewPager? = null
    private var mPagerAdapter: mPagerAdapter? = null
    private val layouts = intArrayOf(R.layout.intro_first, R.layout.intro_second, R.layout.intro_third)
    //private untuk pembuatan dots
    private var Dots_Layout: LinearLayout? = null
    private var dots: Array<ImageView>? = null
    //private untuk pembuatan btn
    private var BtnNext: Button? = null
    private var BtnSkip: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        if (PreferenceManager(this).checkPreference()) {
            loadHome()
        }
        //if untuk membuat transparan di bagian atas nafbar sperti wifi dll
        if (Build.VERSION.SDK_INT >= 19) {
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        } else {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        }

        mPager = findViewById<View>(R.id.view_pager) as ViewPager
        mPagerAdapter = mPagerAdapter(layouts, this)
        mPager!!.adapter = mPagerAdapter

        Dots_Layout = findViewById<View>(R.id.dots_Layout) as LinearLayout

        BtnNext = findViewById<View>(R.id.btn_next) as Button
        BtnSkip = findViewById<View>(R.id.btn_skip) as Button

        BtnNext!!.setOnClickListener(this)
        BtnSkip!!.setOnClickListener(this)
        createDots(0)
        mPager!!.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {

                createDots(position)

                if (position == layouts.size - 1)
                // kondisiuntuk menghilangkan text di slide terakhir
                {
                    BtnNext!!.setText("Done")
                    BtnSkip!!.visibility = View.INVISIBLE// untuk menghilangkan text di slide terakhir
                }
                else
                {
                    BtnNext!!.setText("Next")
                    BtnSkip!!.visibility = View.VISIBLE// untuk terlihat di di slide yg lain
                }
            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })
    }

    private fun createDots(current_position: Int) {
        if (Dots_Layout != null) {
            Dots_Layout!!.removeAllViews()
        }
        dots = Array(layouts.size,{i ->ImageView(this)})

        for (i in layouts.indices) {
            dots!![i] = ImageView(this)
            if (i == current_position) {
                dots!![i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.active_dots))
            } else {
                dots!![i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.default_dots))
            }

            val params =
                LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            params.setMargins(4, 0, 4, 0)

            Dots_Layout!!.addView(dots!![i], params)

        }
    }

    override fun onClick(view: View) {

        when (view.id) {
            R.id.btn_next -> loadNextSlide()

            R.id.btn_skip -> {
                loadHome()
                PreferenceManager(this).writePreference()
            }
        }

    }

    private fun loadHome() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

    private fun loadNextSlide() {
        val next_slide = mPager!!.currentItem + 1
        if (next_slide < layouts.size) {
            mPager!!.currentItem = next_slide
        } else {
            loadHome()
            PreferenceManager(this).writePreference()
        }
    }
}
