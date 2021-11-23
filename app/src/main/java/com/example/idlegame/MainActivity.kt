package com.example.idlegame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import java.lang.Integer.getInteger

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var clicks = 0
        var clickIncr = 0
        var clickMult = 0
        val points = findViewById<TextView>(R.id.idPoints)
        val clicked = findViewById<ImageButton>(R.id.imgBtn)

        val extras = intent.extras
        if (extras != null) {
            clicks = extras.getInt("iron")
            clickMult = extras.getInt("clickMult")
            clickIncr = extras.getInt("clickIncr")
            //The key argument here must match that used in the other activity
            points.text = (clicks).toString() + " iron"
        }

        clicked.setOnClickListener {
            clicks += (clickIncr + 1) * (clickMult+1)
            points.text = (clicks).toString() + " iron"
        }

        // Button to go to shop menu
        val btnShop = findViewById<Button>(R.id.btnShop)
        btnShop.setOnClickListener{
            val i = Intent(this, Shop::class.java)
            i.putExtra("iron", clicks)
            i.putExtra("clickMult", clickMult)
            i.putExtra("clickIncr", clickIncr)
            startActivity(i)

        }
    }
}
