package com.example.eventm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL
import androidx.recyclerview.widget.RecyclerView
import com.example.eventm.Adapter.AgendaAdapter
import com.example.eventm.Adapter.FragmentAgendaAdapter
import com.example.eventm.Item.itemAgenda
import kotlinx.android.synthetic.main.activity_agenda.*

class AgendaActivity : AppCompatActivity() {

    lateinit var itemList: MutableList<itemAgenda>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agenda)
        back_Agenda.setOnClickListener {
            startActivity( Intent(this,MainActivity::class.java))
            finish()
        }

        itemList= ArrayList<itemAgenda>()
        itemList.add(itemAgenda("1","mon"))
        itemList.add(itemAgenda("2","tue"))
        itemList.add(itemAgenda("3","wed"))
        itemList.add(itemAgenda("4","mon"))
        itemList.add(itemAgenda("5","tue"))
        itemList.add(itemAgenda("6","wed"))
        itemList.add(itemAgenda("7","mon"))
        itemList.add(itemAgenda("8","tue"))
        itemList.add(itemAgenda("9","wed"))
        itemList.add(itemAgenda("10","mon"))
        itemList.add(itemAgenda("11","tue"))
        itemList.add(itemAgenda("12","wed"))

        rv_Agenda.apply {
            layoutManager = LinearLayoutManager(this@AgendaActivity, LinearLayout.HORIZONTAL, false)
            adapter = AgendaAdapter(this@AgendaActivity, itemList)
        }
        view_pager_Agenda.adapter =FragmentAgendaAdapter(supportFragmentManager)

    }
}


