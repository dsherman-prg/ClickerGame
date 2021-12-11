package com.example.idlegame

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class Customization : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customization)

        val editedTownName = findViewById<EditText>(R.id.txtTownName)
        val editedBirthMonth = findViewById<Spinner>(R.id.spnMonth)
        val editedBirthDate = findViewById<EditText>(R.id.txtDay)
        val townNameLabel = findViewById<TextView>(R.id.cstmIdTitle)
        val editedTownAge = findViewById<EditText>(R.id.txtTownAge)

        var clicks = 0
        var clickIncr = 0
        var clickMult = 0
        var townName: String
        var townAge: String
        var birthdayMonth = 0
        var birthdayDate: String


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
            editedTownName.setText(townName)
            editedBirthDate.setText(birthdayDate)
            townNameLabel.text = townName+"'s Town"
            editedTownAge.setText(townAge)
            editedBirthMonth.setSelection(birthdayMonth)
        }

        // Button to go to home menu
        val btnHome = findViewById<Button>(R.id.cstmBtnHome)
        btnHome.setOnClickListener{
            townName = editedTownName.text.toString()
            birthdayMonth = editedBirthMonth.selectedItemPosition
            birthdayDate = editedBirthDate.text.toString()
            townAge = editedTownAge.text.toString()
            val i = Intent(this, MainActivity::class.java)
            i.putExtra("iron", clicks)
            i.putExtra("clickMult", clickMult)
            i.putExtra("clickIncr", clickIncr)
            i.putExtra("townName", townName)
            i.putExtra("townAge", townAge)
            i.putExtra("userBirthdayMonth", birthdayMonth)
            i.putExtra("userBirthdayDate", birthdayDate)
            startActivity(i)
        }

        // Button to go to the shop menu
        val btnShop = findViewById<Button>(R.id.cstmBtnShop)
        btnShop.setOnClickListener{
            townName = editedTownName.text.toString()
            birthdayMonth = editedBirthMonth.selectedItemPosition
            birthdayDate = editedBirthDate.text.toString()
            townAge = editedTownAge.text.toString()
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
    }
}