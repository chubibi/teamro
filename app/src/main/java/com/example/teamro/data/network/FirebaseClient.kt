package com.example.teamro.data.network

import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FirebaseClient @Inject constructor() {
    val db = FirebaseFirestore.getInstance()
}
