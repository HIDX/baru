package com.example.eventm

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.eventm.Adapter.IntroAdapter
import com.example.eventm.Item.ScreenItem
import com.google.android.material.tabs.TabLayout
import java.util.ArrayList

class IntroActivity : AppCompatActivity() {
    private var screenPager: ViewPager? = null
    lateinit var introAdapter: IntroAdapter
    lateinit var Tabindicator: TabLayout
    lateinit var btnNext: Button
    internal var position = 0
    lateinit var btngetStarted: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //make the activity on full
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        //whe this activity is about to be launch we need check if its openened before or not
        //preferense untuk save data dan tidak menampilkan lagi dan langsung menuju login activity

        if (restorePrefData()) {
            val mainActivity = Intent(applicationContext, LoginActivity::class.java)
            startActivity(mainActivity)
            finish()
        }
        setContentView(R.layout.activity_intro)

        //ini view
        btngetStarted = findViewById(R.id.btn_skip)
        btnNext = findViewById(R.id.btn_next)
        Tabindicator = findViewById<TabLayout>(R.id.tl_intro)

        //fill list screen
        val mlist = ArrayList<ScreenItem>()
        mlist.add(ScreenItem("hi", "lodiquhiusadsasdada", R.drawable.ic_about))
        mlist.add(
            ScreenItem(
                "halo",
                "loreloreqkdnqkndkqekiedugquegiudiquhiusadsasdada",
                R.drawable.ic_about
            )
        )
        mlist.add(
            ScreenItem(
                "hiya",
                "loreloreqkdnqkndkqekiedugquegiudiquhiusadsasdada",
                R.drawable.ic_about
            )
        )

        //setup viewpager
        screenPager = findViewById(R.id.view_pager_intro)
        introAdapter = IntroAdapter(this, mlist)
        screenPager!!.adapter = introAdapter

        //setup tablayout with viewpager
        Tabindicator.setupWithViewPager(screenPager)

        //next button click
        btnNext.setOnClickListener {
            position = screenPager!!.currentItem
            if (position < mlist.size) {
                position++
                screenPager!!.currentItem = position

            }
            if (position == mlist.size) {
                btngetStarted.visibility = View.INVISIBLE
                loadLastScreen()

            }
        }

        screenPager!!.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {

                if (position == mlist.size - 1) {
                    btnNext.text = "Done"
                    btngetStarted.visibility = View.INVISIBLE
                } else {
                    btnNext.text = "Next"
                    btngetStarted.visibility = View.VISIBLE
                }
            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })

        btngetStarted.setOnClickListener {
            val mainActivity = Intent(applicationContext, LoginActivity::class.java)
            startActivity(mainActivity)
            savePrefsData()
            finish()
        }

    }


    private fun restorePrefData(): Boolean {
        val pref = applicationContext.getSharedPreferences("mypref", Context.MODE_PRIVATE)
        return pref.getBoolean("isntroOpned", false)
    }

    private fun savePrefsData() {
        val pref = applicationContext.getSharedPreferences("mypref", Context.MODE_PRIVATE)
        val editor = pref.edit()
        editor.putBoolean("isntroOpned", true)
        editor.commit()
    }

    //show the getstarted
    private fun loadLastScreen() {
        startActivity(Intent(this, LoginActivity::class.java))
        savePrefsData()
        btnNext.text = "done"
        btngetStarted.visibility = View.INVISIBLE
    }
}