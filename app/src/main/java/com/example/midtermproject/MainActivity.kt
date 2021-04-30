package com.example.midtermproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var addCardButton : Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addCardButton = findViewById(R.id.add_card_button)

        addCardButton.setOnClickListener {
            val intent = Intent(this,AddCardActivity::class.java)
            startActivity(intent)
        }

    }
}