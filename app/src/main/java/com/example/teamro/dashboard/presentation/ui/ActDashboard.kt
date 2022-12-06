package com.example.teamro.dashboard.presentation.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.teamro.dashboard.presentation.viewmodel.DashboardViewModel
import com.example.teamro.databinding.ActDashboardBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ActDashboard : AppCompatActivity() {

    private lateinit var binding: ActDashboardBinding
    private val viewModel: DashboardViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.getDataUser()

        viewModel.dataUser.observe(this) {
            it.forEach(){
                binding.tvUser.text = it.name
                binding.tvdtaEstatura.text = it.height.toString()
                binding.tvdtaPeso.text = it.peso.toString()
                binding.tvdtaRetos.text = it.retos.toString()
            }
        }
    }


}
