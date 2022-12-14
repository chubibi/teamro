package com.example.teamro.register.domain.repository

import androidx.lifecycle.MutableLiveData
import com.example.teamro.data.network.FirebaseClient
import com.example.teamro.register.presentation.model.Goal
import javax.inject.Inject

class GoalRepository @Inject constructor(private val firebaseClient: FirebaseClient) {

    fun getData(): MutableLiveData<MutableList<Goal>> {
        val mutableData = MutableLiveData<MutableList<Goal>>()
        firebaseClient.db.collection("goal").get().addOnSuccessListener { result ->
            val listGoal = mutableListOf<Goal>()
            for (document in result) {
                listGoal.add(Goal(document.getString("namegoal") ?: ""))
            }
            mutableData.value = listGoal
        }
        return mutableData
    }
}
