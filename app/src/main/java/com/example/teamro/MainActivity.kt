package com.example.teamro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/**THIS IS SPLASHCREEN**/

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
    }
}