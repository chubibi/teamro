package com.example.teamro.register.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.teamro.databinding.FrgGoalBinding
import com.example.teamro.register.presentation.model.Goal
import com.example.teamro.register.presentation.viewmodel.RegisterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FrgGoal : Fragment() {
    private lateinit var binding: FrgGoalBinding
    private lateinit var adapterGoal: GoalAdapter
    private lateinit var viewModel: RegisterViewModel

    // private val viewModel: RegisterViewModel by viewModels()
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
        viewModel = requireActivity().run {
            ViewModelProvider(this)[RegisterViewModel::class.java]
        }
        viewModel.getGoals()
        binding.shmViewLoad.startShimmer()
        viewModel.goals.observe(viewLifecycleOwner) {
            binding.shmViewLoad.stopShimmer()
            binding.shmViewLoad.visibility = View.GONE
            adapterGoal = GoalAdapter(it.toList()) { goals -> onItemSelect(goals) }
            binding.rvGoal.adapter = adapterGoal
        }
    }

    private fun onItemSelect(goal: Goal) {
        viewModel.saveGoal(goal.goal)
        // Toast.makeText(requireContext(), goal.goal, Toast.LENGTH_SHORT).show()
    }
}
