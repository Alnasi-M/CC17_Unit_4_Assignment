package com.chayoticace.cc17unit4assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button).setOnClickListener({loginAccepted()})

    }
    private fun loginAccepted(){
        val intent = Intent(this, MainActivity2::class.java)
        startActivity(intent)
    }
}