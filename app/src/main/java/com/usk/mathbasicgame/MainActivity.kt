package com.usk.mathbasicgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var addition : Button
    lateinit var subtraction : Button
    lateinit var multi : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.title = "Simple Math Game"

        addition = findViewById(R.id.addButton)
        subtraction = findViewById(R.id.subButton)
        multi = findViewById(R.id.mulButton)

        addition.setOnClickListener {

            val intent = Intent(this@MainActivity, GameActivity::class.java)
            startActivity(intent);

        }

    }
}