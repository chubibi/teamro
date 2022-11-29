package com.example.teamro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.teamro.databinding.FrgSingInBinding

class FrgSingIn : Fragment() {
    private lateinit var binding: FrgSingInBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FrgSingInBinding.inflate(inflater, container, false)
        return binding.root
    }
}
