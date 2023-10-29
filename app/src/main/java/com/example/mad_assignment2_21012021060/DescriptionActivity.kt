package com.example.mad_assignment2_21012021060

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DescriptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description)

        val descriptionText : TextView = findViewById(R.id.descriptionTxt)
        descriptionText.text = intent.getStringExtra("description")
    }
}