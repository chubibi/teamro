package com.example.teamro.register.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.teamro.databinding.FrgGoalBinding
import com.example.teamro.register.presentation.model.Goal

class FrgGoal : Fragment() {
    private lateinit var binding: FrgGoalBinding
    private lateinit var adapterGoal: GoalAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FrgGoalBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val recyclerView = binding.rvGoal
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val goalList = listOf(Goal("Perder Peso"), Goal("Ganar musculo"), Goal("Ser mas saludable"))
        adapterGoal = GoalAdapter(goalList) { onItemSelect(it) }
        binding.rvGoal.adapter = adapterGoal
    }

    private fun onItemSelect(goal: Goal) {
        Toast.makeText(requireContext(), goal.goal, Toast.LENGTH_SHORT).show()
    }
}
