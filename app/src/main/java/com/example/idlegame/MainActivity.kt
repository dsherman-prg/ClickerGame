package com.example.idlegame

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {


    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var clicks = 0
        var clickIncr = 0
        var clickMult = 0
        val points = findViewById<TextView>(R.id.idPoints)
        val clicked = findViewById<ImageButton>(R.id.imgBtn)
        val townNameLabel = findViewById<TextView>(R.id.idTitle)
        val birthdayAnn = findViewById<TextView>(R.id.idBirthdayAnn)
        var townName = "User"
        var townAge = "0"
        var birthdayMonth = 0
        var birthdayDate = ""
        var birthday = false
        val date = LocalDate.now()
        val dayFormatter = DateTimeFormatter.ofPattern("dd")
        val monthFormatter = DateTimeFormatter.ofPattern("MM")
        var currentMonth = ""
        var currentDay = ""

        val extras = intent.extras
        if (extras != null) {
            clicks = extras.getInt("iron")
            clickMult = extras.getInt("clickMult")
            clickIncr = extras.getInt("clickIncr")
            townName = extras.getString("townName").orEmpty()
            townAge = extras.getString("townAge").orEmpty()
            birthdayMonth = extras.getInt("userBirthdayMonth")
            birthdayDate = extras.getString("userBirthdayDate").orEmpty()
            //The key argument here must match that used in the other activity
            points.text = (clicks).toString() + " iron"
            townNameLabel.text = townName+"'s Town"
        }

        // Check if it is the user's birthday
        currentMonth = date.format(monthFormatter)
        currentDay = date.format(dayFormatter)
        // add one to birthdayMonth because spinner starts at 0 while calendar starts at 1
        if ((birthdayMonth)+1 == currentMonth.toInt() && birthdayDate == currentDay){
            birthdayAnn.visibility = View.VISIBLE
            birthday = true
        }

        //When the image is clicked add value to the iron/points
        clicked.setOnClickListener {
            if (birthday){
                clicks += ((clickIncr + 1) * (clickMult+1))*2
                points.text = (clicks).toString() + " iron"
            }else{
                clicks += (clickIncr + 1) * (clickMult+1)
                points.text = (clicks).toString() + " iron"
            }
        }

        // Button to go to shop menu
        val btnShop = findViewById<Button>(R.id.btnShop)
        btnShop.setOnClickListener{
            val i = Intent(this, Shop::class.java)
            i.putExtra("iron", clicks)
            i.putExtra("clickMult", clickMult)
            i.putExtra("clickIncr", clickIncr)
            i.putExtra("townName", townName)
            i.putExtra("townAge", townAge)
            i.putExtra("userBirthdayMonth", birthdayMonth)
            i.putExtra("userBirthdayDate", birthdayDate)
            startActivity(i)
        }

        // Button to go to the customization menu
        val btnCstm = findViewById<Button>(R.id.btnCstm)
        btnCstm.setOnClickListener{
            val i = Intent(this, Customization::class.java)
            i.putExtra("iron", clicks)
            i.putExtra("clickMult", clickMult)
            i.putExtra("clickIncr", clickIncr)
            i.putExtra("townName", townName)
            i.putExtra("townAge", townAge)
            i.putExtra("userBirthdayMonth", birthdayMonth)
            i.putExtra("userBirthdayDate", birthdayDate)
            startActivity(i)
        }
    }
}
