package com.example.teamro.dashboard.domain.repository

import androidx.lifecycle.MutableLiveData
import com.example.teamro.dashboard.data.model.User
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

class DashboardRepository @Inject constructor() {

    private var TAG = "CONECTION_DATABASE"
    private var db = FirebaseFirestore.getInstance()

    fun getUserData(): MutableLiveData<MutableList<User>> {
        val mutableData = MutableLiveData<MutableList<User>>()

        db.collection("user")
            .get()
            .addOnSuccessListener { result ->
                val listUser = mutableListOf<User>()
                for (document in result) {
                    listUser.add(
                        User(
                            document.get("height")!!.toString().toInt(),
                            document.getString("name")!!,
                            document.get("peso")!!.toString().toInt(),
                            document.get("retos")!!.toString().toInt()
                        )
                    )
                }
                mutableData.value = listUser
            }
        return mutableData
    }

}