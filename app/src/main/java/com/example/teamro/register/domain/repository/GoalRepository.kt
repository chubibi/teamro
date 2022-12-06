package com.example.teamro.register.domain.repository

import androidx.lifecycle.MutableLiveData
import com.example.teamro.register.presentation.model.Goal
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

class GoalRepository @Inject constructor() {

    fun getData(): MutableLiveData<MutableList<Goal>> {
        val mutableData = MutableLiveData<MutableList<Goal>>()
        FirebaseFirestore.getInstance().collection("goal").get().addOnSuccessListener { result ->
            val listGoal = mutableListOf<Goal>()
            for (document in result) {
                listGoal.add(Goal(document.getString("namegoal") ?: ""))
            }
            mutableData.value = listGoal
        }
        return mutableData
    }
}
