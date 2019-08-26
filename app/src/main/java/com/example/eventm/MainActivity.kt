package com.example.eventm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.LinearLayout.HORIZONTAL
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eventm.Adapter.ProductAdapter
import com.example.eventm.Adapter.SliderHomeAdapter
import com.example.eventm.Item.ItemProduct
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    lateinit var itemList: MutableList<ItemProduct>
   //private var Dots_Home: LinearLayout? = null
   // private var dots: Array <ImageView>? = null
   val Img_Slide = intArrayOf(R.drawable.tablet,R.drawable.smartphone,R.drawable.ayy)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //itemProduct
        itemList = ArrayList<ItemProduct>()
        itemList.add(ItemProduct("Barcode", R.drawable.ic_qrcode))
        itemList.add(ItemProduct("Agenda", R.drawable.ic_agenda))
        itemList.add(ItemProduct("Message", R.drawable.ic_message))
        itemList.add(ItemProduct("Map", R.drawable.ic_map))
        itemList.add(ItemProduct("Gallery", R.drawable.ic_gallery))
        itemList.add(ItemProduct("Document", R.drawable.ic_document))
        itemList.add(ItemProduct("Quiz", R.drawable.ic_quiz))
        itemList.add(ItemProduct("Souvenir", R.drawable.ic_souvenir))
        itemList.add(ItemProduct("Feedback", R.drawable.ic_feedback))
        itemList.add(ItemProduct("Survey", R.drawable.ic_survey))
        itemList.add(ItemProduct("About", R.drawable.ic_about))
        itemList.add(ItemProduct("Help", R.drawable.ic_help))

        //slider menu
        val Rview_slide=findViewById<View>(R.id.rv_menu_slide) as RecyclerView // gunaka as rv untuk mengimpor rv nya
        val name_Slide= arrayOf("tablet","smartphone","computer")
        val LManager = LinearLayoutManager(this, HORIZONTAL,false)//jika merah impor saja manual
        Rview_slide.setLayoutManager(LManager)
        Rview_slide.adapter = SliderHomeAdapter(Img_Slide,name_Slide,this)


        //rv item menu
        val myrvItem = findViewById<View>(R.id.rv_item_product) as RecyclerView
        val Adapter_item = ProductAdapter(this, itemList)
        myrvItem.layoutManager = GridLayoutManager(this, 3)
        myrvItem.adapter = Adapter_item

    }

}
