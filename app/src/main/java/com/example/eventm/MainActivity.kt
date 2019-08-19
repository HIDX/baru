package com.example.eventm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.LinearLayout.HORIZONTAL
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eventm.Adapter.SliderHomeAdapter

class MainActivity : AppCompatActivity() {

   //private var Dots_Home: LinearLayout? = null
   // private var dots: Array <ImageView>? = null
   val Img_Slide = intArrayOf(R.drawable.tablet,R.drawable.smartphone,R.drawable.ayy)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val Rview =findViewById<View>(R.id.rv_menu_slide) as RecyclerView // gunaka as rv untuk mengimpor rv nya
        val name_Slide= arrayOf("tablet","smartphone","computer")
        val LManager = LinearLayoutManager(this,HORIZONTAL,false)//jika merah impor saja manual
        Rview.setLayoutManager(LManager)
        //Dots_Home = findViewById<View>(R.id.dots_Card) as LinearLayout
        Rview.adapter = SliderHomeAdapter(Img_Slide,name_Slide,this)
       // createDots(0)

    }
    /*private fun createDots(current_position: Int) {
        if (Dots_Home != null) {
            Dots_Home!!.removeAllViews()
        }
        dots = Array(Img_Slide.size,{i ->ImageView(this)})

        for (i in Img_Slide.indices) {
            dots!![i] = ImageView(this)
            if (i == current_position) {
                dots!![i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.active_dots))
            } else {
                dots!![i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.default_dots))
            }

            val params =
                LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            params.setMargins(4, 0, 4, 0)

            Dots_Home!!.addView(dots!![i], params)

        }
    }*/
}
