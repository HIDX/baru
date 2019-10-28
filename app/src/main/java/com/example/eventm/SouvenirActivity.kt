package com.example.eventm

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eventm.Adapter.SliderSouvenirAdapter
import kotlinx.android.synthetic.main.card_redeem.view.*
import kotlinx.android.synthetic.main.cardview_souvenir.*

class SouvenirActivity : AppCompatActivity() {
   lateinit var  redeem_btn: Button
    val Img_rv_souvenir = intArrayOf(R.drawable.tablet,R.drawable.smartphone,R.drawable.ayy,R.drawable.smartphone,R.drawable.ayy)
    @SuppressLint( "WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_souvenir)

        //slider menu top
        val Rview_slide=findViewById<View>(R.id.rv_souvenir) as RecyclerView // gunaka as rv untuk mengimpor rv nya
        val name_Slide= arrayOf("tablet","smartphone","computer","smartphone","computer")
        val LManager = LinearLayoutManager(this, LinearLayout.VERTICAL,false)//jika merah impor saja manual
        Rview_slide.setLayoutManager(LManager)
        Rview_slide.adapter = SliderSouvenirAdapter(Img_rv_souvenir,name_Slide,this)

        //click btm

        /*val redeem_btn=findViewById<View>(R.id.text_redeem_btn) as Button
            redeem_btn.setOnClickListener {
            val mDialogView = LayoutInflater.from(this).inflate(R.layout.card_redeem,null)
            //AlertBuilder

            val mBuilder = AlertDialog.Builder(this,R.style.CustomDialog)//CustumDialog untuk transparan di style
                .setView(mDialogView)

            //Show Dialog
            val mAlertDialog=mBuilder.show()

            mDialogView.dialogCancelBtn.setOnClickListener {
                //dismiss dialog
                mAlertDialog.dismiss()
            }

        }*/




    }
}
