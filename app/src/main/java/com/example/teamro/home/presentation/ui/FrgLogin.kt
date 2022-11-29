package com.example.teamro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.teamro.databinding.FrgLoginBinding

class FrgLogin : Fragment() {

    lateinit var binding: FrgLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FrgLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLoginfacebook.setOnClickListener {
            Toast.makeText(requireContext(), "CLIC CON FACEBOOK", Toast.LENGTH_SHORT).show()
        }
        binding.btnLoginGoogle.setOnClickListener {
            Toast.makeText(requireContext(), "CLIC CON GOOGLE", Toast.LENGTH_SHORT).show()
        }
        binding.btnSingCountNew.setOnClickListener {
            findNavController().navigate(R.id.frgSingIn)
        }
        binding.tvGoToRegister.setOnClickListener {
            Toast.makeText(requireContext(), "CLIC CON REGISTRAR", Toast.LENGTH_SHORT).show()
        }
    }
}
