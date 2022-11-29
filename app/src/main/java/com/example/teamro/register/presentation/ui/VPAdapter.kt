package com.example.teamro.register.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class VPAdapter(activity: AppCompatActivity) :
    FragmentStateAdapter(activity) {
    private var fragmentArrayList: ArrayList<Fragment> = ArrayList()

    override fun getItemCount() = fragmentArrayList.size

    override fun createFragment(position: Int) = fragmentArrayList[position]

    fun addFragment(fragment: Fragment) {
        fragmentArrayList.add(fragment)
    }

    fun getSize() = fragmentArrayList.size
}
