package com.example.eventm.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.eventm.Item.ItemProduct
import android.app.Activity
import com.example.eventm.*


class ProductAdapter(private val mcontext: Context, private val mData: List<ItemProduct>) :
    RecyclerView.Adapter<ProductAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View
        val mInflater = LayoutInflater.from(mcontext)
        view = mInflater.inflate(R.layout.cardview_item_product, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.tv_item_title.setText(mData[position].title)// ambil data produt title
        holder.img_item.setImageResource(mData[position].ImageM)//ambil data produt img
        // untuk inten ke card view home
        holder.cardView.setOnClickListener {
            if (position == 0) {
                val intentQrcode = Intent(mcontext, QrcodeActivity::class.java)
                mcontext.startActivity(intentQrcode)
                (mcontext as Activity).finish()
            } else if (position == 1) {
                val intentAgenda = Intent(mcontext, AgendaActivity::class.java)
                mcontext.startActivity(intentAgenda)
                (mcontext as Activity).finish()
            }else if (position == 2) {
                val intentAgenda = Intent(mcontext, AgendaActivity::class.java)
                mcontext.startActivity(intentAgenda)
                (mcontext as Activity).finish()
            }else if (position == 3) {
                val intentAgenda = Intent(mcontext, AgendaActivity::class.java)
                mcontext.startActivity(intentAgenda)
                (mcontext as Activity).finish()
            }else if (position == 4) {
                val intentAgenda = Intent(mcontext, AgendaActivity::class.java)
                mcontext.startActivity(intentAgenda)
                (mcontext as Activity).finish()
            }else if (position == 5) {
                val intentAgenda = Intent(mcontext, AgendaActivity::class.java)
                mcontext.startActivity(intentAgenda)
                (mcontext as Activity).finish()
            }else if (position == 6) {
                val intentAgenda = Intent(mcontext, QuizActivity::class.java)
                mcontext.startActivity(intentAgenda)
                (mcontext as Activity).finish()
            }else if (position == 7) {
                val intentAgenda = Intent(mcontext, SouvenirActivity::class.java)
                mcontext.startActivity(intentAgenda)
                (mcontext as Activity).finish()
            }else if (position == 8) {
                val intentAgenda = Intent(mcontext, AgendaActivity::class.java)
                mcontext.startActivity(intentAgenda)
                (mcontext as Activity).finish()
            }else if (position == 9) {
                val intentAgenda = Intent(mcontext, AgendaActivity::class.java)
                mcontext.startActivity(intentAgenda)
                (mcontext as Activity).finish()
            }else if (position == 10) {
                val intentAgenda = Intent(mcontext, AgendaActivity::class.java)
                mcontext.startActivity(intentAgenda)
                (mcontext as Activity).finish()
            }else if (position == 11) {
                val intentAgenda = Intent(mcontext, AgendaActivity::class.java)
                mcontext.startActivity(intentAgenda)
                (mcontext as Activity).finish()
            }
        }
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal var tv_item_title: TextView
        internal var img_item: ImageView
        internal var cardView: CardView

        init {

            tv_item_title = itemView.findViewById<View>(R.id.title_img_id) as TextView
            img_item = itemView.findViewById<View>(R.id.item_img_id) as ImageView
            cardView = itemView.findViewById<View>(R.id.cv_id_product) as CardView
        }
    }
}