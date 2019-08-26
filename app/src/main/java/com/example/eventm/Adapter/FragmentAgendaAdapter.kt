package com.example.eventm.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.eventm.fragment.FirstFragment
import com.example.eventm.fragment.SecondFragment
import com.example.eventm.fragment.ThridFragment

class FragmentAgendaAdapter (fm:FragmentManager): FragmentPagerAdapter(fm){
    //list yg menampung objek fragment
    private val pages = listOf(
        FirstFragment(),
        SecondFragment(),
        ThridFragment()
    )
    override fun getItem(position: Int): Fragment {
        return pages[position]
    }

    override fun getCount(): Int {
        return pages.size
    }



}