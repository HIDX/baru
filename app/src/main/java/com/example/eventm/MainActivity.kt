package com.example.eventm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout.HORIZONTAL
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eventm.Adapter.ProductAdapter
import com.example.eventm.Adapter.SliderHomeAdapter
import com.example.eventm.Item.ItemProduct
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private var isVisible: Boolean? = false
    lateinit var mRelativeZaplon: RelativeLayout
    lateinit var mRelativeToSlide: RelativeLayout
    lateinit var mAnimationManager: ExpandOrCollapse
    lateinit var txthm: TextView
    lateinit var itemList: MutableList<ItemProduct>
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
        itemList.add(ItemProduct("Souvenir",R.drawable.ic_souvenir))
        itemList.add(ItemProduct("Feedback",R.drawable.ic_feedback))
        itemList.add(ItemProduct("Survey",R.drawable.ic_survey))
        itemList.add(ItemProduct("About",R.drawable.ic_about))
        itemList.add(ItemProduct("Help",R.drawable.ic_help))

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

        //rl more/hide
        txthm=findViewById(R.id.txt_hm) as TextView
        mAnimationManager = ExpandOrCollapse()
        mRelativeZaplon = findViewById<View>(R.id.relativeZaplon) as RelativeLayout
        mRelativeToSlide = findViewById<View>(R.id.relativevToSlide) as RelativeLayout
        mRelativeZaplon!!.setOnClickListener(View.OnClickListener {//kondisi untuk membuat anismasi expand/collapse
            if (this!!.isVisible!!) {
                mAnimationManager?.collapse(mRelativeToSlide!!, 500, 880)
                isVisible = false
                txthm.setText("More ∨")

            } else if (!isVisible!!) {
                mAnimationManager?.expand(mRelativeToSlide!!, 500, 1800)
                isVisible = true
                txthm.setText("Hide ∧")

            }
        })
    }

}


