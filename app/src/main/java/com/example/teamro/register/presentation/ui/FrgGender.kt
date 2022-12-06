package com.example.teamro.register.presentation.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.teamro.databinding.FrgGenderBinding
import com.example.teamro.register.presentation.viewmodel.RegisterViewModel

class FrgGender : Fragment() {
    private lateinit var binding: FrgGenderBinding
    private lateinit var viewModel: RegisterViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FrgGenderBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("ResourceAsColor")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = requireActivity().run {
            ViewModelProvider(this)[RegisterViewModel::class.java]
        }
        with(binding) {
            cvMale.setOnClickListener {
                cvMale.isChecked = true
                cvFemale.isChecked = false
                viewModel.saveGender(tvMale.text.toString())
            }
            cvFemale.setOnClickListener {
                cvFemale.isChecked = true
                cvMale.isChecked = false
                viewModel.saveGender(tvFemale.text.toString())
            }
        }
    }
}
