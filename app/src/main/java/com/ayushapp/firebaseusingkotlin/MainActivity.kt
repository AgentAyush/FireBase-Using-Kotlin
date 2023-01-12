package com.ayushapp.firebaseusingkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var InsertBtn : Button
    private lateinit var AddBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        InsertBtn = findViewById(R.id.button1)
        AddBtn = findViewById((R.id.button2))

        InsertBtn.setOnClickListener {
            val insertIntent = Intent(this, InsertData :: class.java)
            startActivity(insertIntent)
        }
        AddBtn.setOnClickListener {
            val addIntent = Intent(this, AddData :: class.java)
            startActivity((addIntent))
        }
    }


}