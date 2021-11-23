package com.example.idlegame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Customization : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customization)

        // Button to go to home menu
        var btnHome = findViewById<Button>(R.id.btnHome)
        btnHome.setOnClickListener{

            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)

        }
        var btnShop = findViewById<Button>(R.id.btnShop)
        btnShop.setOnClickListener{

            var intent = Intent(this,Shop::class.java)
            startActivity(intent)

        }
    }
}