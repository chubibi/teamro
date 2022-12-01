package com.example.teamro.register.presentation.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.teamro.dashboard.presentation.ui.ActDashboard
import com.example.teamro.databinding.ActRegisterBinding

class ActRegister : AppCompatActivity() {
    private lateinit var binding: ActRegisterBinding
    private lateinit var viewPager: ViewPager2
    private var size = 0

    private val pagerCallback = object : ViewPager2.OnPageChangeCallback() {

        override fun onPageSelected(position: Int) {
            with(binding) {
                if (position == size - 1) {
                    tvNext.text = "Finalizar"
                    tvNext.setOnClickListener {
                        val intent = Intent(applicationContext, ActDashboard::class.java)
                        startActivity(intent)
                    }
                } else {
                    tvNext.text = "Siguiente"
                    tvNext.setOnClickListener {
                        viewPager.currentItem = position + 1
                    }
                }
                if (position >= 1) {
                    tvBack.visibility = View.VISIBLE
                    tvBack.setOnClickListener {
                        viewPager.currentItem = position - 1
                    }
                } else {
                    tvBack.visibility = View.GONE
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActRegisterBinding.inflate(layoutInflater)
        viewPager = binding.vpRegister
        setContentView(binding.root)
        val vpAdapter = VPAdapter(this)
        addAllFragment(vpAdapter)
        size = vpAdapter.getSize()
        viewPager.adapter = vpAdapter
        viewPager.registerOnPageChangeCallback(pagerCallback)
        binding.diRegister.setViewPager2(viewPager)
    }

    private fun addAllFragment(vpAdapter: VPAdapter) {
        vpAdapter.addFragment(FrgGender())
        vpAdapter.addFragment(FrgGoal())
        vpAdapter.addFragment(FrgAge())
    }
}
