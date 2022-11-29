package com.example.teamro.register.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.teamro.databinding.FrgGoalBinding

class FrgGoal : Fragment() {
    private lateinit var binding: FrgGoalBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FrgGoalBinding.inflate(inflater, container, false)
        return binding.root
    }
}
