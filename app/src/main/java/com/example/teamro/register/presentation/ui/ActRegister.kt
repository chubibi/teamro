package com.example.teamro.register.presentation.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.teamro.dashboard.presentation.ui.ActDashboard
import com.example.teamro.databinding.ActRegisterBinding
import com.example.teamro.register.presentation.viewmodel.RegisterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ActRegister : AppCompatActivity() {
    private lateinit var binding: ActRegisterBinding
    private lateinit var viewPager: ViewPager2
    private var backEnable = false
    private var size = 0
    private val viewModel: RegisterViewModel by viewModels()

    private val pagerCallback = object : ViewPager2.OnPageChangeCallback() {

        override fun onPageSelected(position: Int) {
            with(binding) {
                if (position == size - 1) {
                    tvNext.text = "Finalizar"
                    tvNext.setOnClickListener {
                        viewModel.saveAllData()
                    }
                } else {
                    tvNext.text = "Siguiente"
                    tvNext.setOnClickListener {
                        backEnable = false
                        viewPager.currentItem = position + 1
                    }
                }
                if (position >= 1) {
                    tvBack.visibility = View.VISIBLE
                    tvBack.setOnClickListener {
                        backEnable = true
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
        viewModel.allData.observe(this) {
            if (it) {
                val intent = Intent(applicationContext, ActDashboard::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Faltan llenar datos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun addAllFragment(vpAdapter: VPAdapter) {
        vpAdapter.addFragment(FrgGender())
        vpAdapter.addFragment(FrgGoal())
        vpAdapter.addFragment(FrgAge())
    }
}
