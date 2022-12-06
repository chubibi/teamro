package com.example.teamro.register.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.teamro.databinding.FrgAgeBinding
import com.example.teamro.register.presentation.viewmodel.RegisterViewModel

class FrgAge : Fragment() {
    private lateinit var binding: FrgAgeBinding
    private lateinit var viewModel: RegisterViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FrgAgeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = requireActivity().run {
            ViewModelProvider(this)[RegisterViewModel::class.java]
        }
        setupNumberPicker()
    }

    private fun setupNumberPicker() {
        val numberPicker = binding.numberPicker
        numberPicker.minValue = 5
        numberPicker.maxValue = 80
        numberPicker.value = 18
        numberPicker.wrapSelectorWheel = true
        viewModel.saveAge(numberPicker.value)
        numberPicker.setOnValueChangedListener { picker, oldVal, newVal ->
            viewModel.saveAge(newVal)
            binding.tvAge.text = "Tu edad es de $newVal  años"
        }
    }
}
