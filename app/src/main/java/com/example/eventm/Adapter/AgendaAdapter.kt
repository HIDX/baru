package com.example.eventm.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.eventm.Item.itemAgenda
import com.example.eventm.R
import kotlinx.android.synthetic.main.item_list_agenda.view.*

class AgendaAdapter (private val mcontext: Context, private val mData: List<itemAgenda>) :
    RecyclerView.Adapter<AgendaAdapter.ViewHolderAgenda>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderAgenda { //untuk membuat suatu tampilan dan mengembalikan
        val view:View
        val myInflater=LayoutInflater.from(mcontext)
        view = myInflater.inflate(R.layout.item_list_agenda,parent,false)
        return ViewHolderAgenda(view)

    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: ViewHolderAgenda, position: Int) {//menghubungkan data dengan view holder pada posisi yang ditentukan dalam RecyclerView.
        holder.tv_daynumber.setText(mData[position].numberDay)// ambil data numberday dari itemAgenda
        holder.tv_day.setText(mData[position].day)// ambil data day dari itemAgenda
        holder.LL_combineDay.setOnClickListener {
            if (position == 0) {

                //Toast.makeText(mcontext, "message", Toast.LENGTH_SHORT).show()
            }
        }
    }


    class ViewHolderAgenda(itemView: View): RecyclerView.ViewHolder(itemView) {
        lateinit var tv_daynumber: TextView
        lateinit var tv_day: TextView
        lateinit var  LL_combineDay: LinearLayout
        //lateinit var VPAgenda: ViewPager

        init {
            tv_daynumber =itemView.findViewById(R.id.txt_Agenda_numberDay)
            tv_day = itemView.findViewById(R.id.txt_id_agenda_day)
         // VPAgenda=itemView.findViewById(R.id.view_pager_Agenda)
            LL_combineDay = itemView.findViewById(R.id.LL_Agenda)
        }
    }

}