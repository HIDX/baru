package com.example.eventm.Holder

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.eventm.R
import kotlinx.android.synthetic.main.card_redeem.view.*
import kotlinx.android.synthetic.main.cardview_souvenir.view.*

class HolderSouvenir (itemView: View, private val mContex: Context): RecyclerView.ViewHolder(itemView){
    private val Images : ImageView
    private val Tviews : TextView
    private var btnview : Button? = null
    // var currentHoby :?=null

    init {
        Images =itemView.findViewById<View>(R.id.img_souvenir) as ImageView
        Tviews = itemView.findViewById<View>(R.id.txt_souvenir1) as TextView

        //membuat alert nya
       itemView.text_redeem_btn.setOnClickListener {
           //inflater the dialog with costume view
           val mDialogView = LayoutInflater.from(mContex).inflate(R.layout.card_redeem,null)
           //AlertBuilder
           val mBuilder = AlertDialog.Builder(mContex,R.style.CustomDialog)//CustumDialog untuk transparan di style
               .setView(mDialogView)
           //Show Dialog
           val mAlertDialog=mBuilder.show()

           mDialogView.dialogCancelBtn.setOnClickListener {
               //dismiss dialog
               mAlertDialog.dismiss()
           }
        }


    }

    fun index (item:Int, s:String){
        Glide.with(mContex).load(item).into(Images)
        Tviews.text =s
    }
}