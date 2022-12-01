package com.example.teamro.register.presentation.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.teamro.R
import com.example.teamro.databinding.ItemRowGoalBinding
import com.example.teamro.register.presentation.model.Goal

class GoalAdapter(
    private var goalList: List<Goal>,
    private val onClickListener: (Goal) -> Unit
) :
    RecyclerView.Adapter<GoalAdapter.GoalViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoalViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return GoalViewHolder(layoutInflater.inflate(R.layout.item_row_goal, parent, false))
    }

    override fun onBindViewHolder(holder: GoalViewHolder, position: Int) {
        val item = goalList[position]
        holder.render(item, onClickListener, position)
    }

    override fun getItemCount() = goalList.size

    inner class GoalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemRowGoalBinding.bind(itemView)

        @SuppressLint("NotifyDataSetChanged")
        fun render(goal: Goal, onClickListener: (Goal) -> Unit, position: Int) {
            binding.tvGoal.text = goal.goal
            binding.cvGoal.isChecked = goal.isSelected
            binding.cvGoal.setOnClickListener {
                // goal.isSelected = !goal.isSelected
                // binding.cvGoal.isChecked = goal.isSelected
                goalList = deselectUser(goalList, position)
                notifyDataSetChanged()
                onClickListener(goal)
            }
        }
    }

    fun deselectUser(listGoal: List<Goal>, position: Int): List<Goal> {
        for (i in listGoal.indices) {
            listGoal[i].isSelected = false
        }
        listGoal[position].isSelected = true
        return listGoal
    }
}
