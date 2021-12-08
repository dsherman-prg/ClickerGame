package com.example.idlegame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView

class Shop : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop)
        val points = findViewById<TextView>(R.id.spIdPoints)
        var clicks = 0
        val increment = 2.0
        var clickMultPurc = 0
        var clickIncrPurc = 0
        val clickMultPrice = findViewById<TextView>(R.id.idMultCost)
        val clickIncrPrice = findViewById<TextView>(R.id.idIncrCost)
        val clickMult = findViewById<Button>(R.id.btnMult)
        val clickIncr = findViewById<Button>(R.id.btnIncr)
        var quantity = 0

        val purQuant1 = findViewById<RadioButton>(R.id.idRB1)
        val purQuant10 = findViewById<RadioButton>(R.id.idRB10)
        val purQuant100 = findViewById<RadioButton>(R.id.idRB100)
        val townNameLabel = findViewById<TextView>(R.id.spIdTitle)
        var townName = "User"
        var townAge = ""
        var birthdayMonth = "Jan"
        var birthdayDate = ""

        val extras = intent.extras
        if (extras != null) {
            clicks = extras.getInt("iron")
            clickMultPurc = extras.getInt("clickMult")
            clickIncrPurc = extras.getInt("clickIncr")
            townName = extras.getString("townName").orEmpty()
            townAge = extras.getString("townAge").orEmpty()
            birthdayMonth = extras.getString("userBirthdayMonth").orEmpty()
            birthdayDate = extras.getString("userBirthdayDate").orEmpty()
            //The key argument here must match that used in the other activity
            townNameLabel.text = townName+"'s Town"
        }

        clickMultPrice.text = "Base Cost: "+((1+clickMultPurc)*increment).toString()
        clickIncrPrice.text = "Base Cost: "+((1+clickIncrPurc)*increment).toString()
        points.text = clicks.toString() + " iron"

        clickMult.setOnClickListener {
            if (purQuant1.isChecked){
                quantity = 1
            }else if (purQuant10.isChecked){
                quantity = 10
            }else if (purQuant100.isChecked){
                quantity = 100
            }

            if (clicks >= ((1+clickMultPurc)*increment)*quantity){
                clicks -= (((1+clickMultPurc)*increment)*quantity).toInt()
                clickMultPurc += quantity
                clickMultPrice.text = "Base Cost: "+((1+clickMultPurc)*increment).toString()
                points.text = clicks.toString() + " iron"
            }else{
                print("no")
            }
        }

        clickIncr.setOnClickListener {
            if (purQuant1.isChecked){
                quantity = 1
            }else if (purQuant10.isChecked){
                quantity = 10
            }else if (purQuant100.isChecked){
                quantity = 100
            }

            if (clicks >= ((1+clickIncrPurc)*increment)*quantity){
                clicks -= (((1+clickIncrPurc)*increment)*quantity).toInt()
                clickIncrPurc += quantity
                clickIncrPrice.text = "Base Cost: "+((1+clickIncrPurc)*increment).toString()
                points.text = clicks.toString() + " iron"
            }else{
                print("no")
            }
        }

        // Button to go to home menu
        val btnHome = findViewById<Button>(R.id.spBtnHome)
        btnHome.setOnClickListener{
            val i = Intent(this, MainActivity::class.java)
            i.putExtra("iron", clicks)
            i.putExtra("clickMult", clickMultPurc)
            i.putExtra("clickIncr", clickIncrPurc)
            i.putExtra("townName", townName)
            i.putExtra("townAge", townAge)
            i.putExtra("userBirthdayMonth", birthdayMonth)
            i.putExtra("userBirthdayDate", birthdayDate)
            startActivity(i)
        }
        val btnCstm = findViewById<Button>(R.id.spBtnCstm)
        btnCstm.setOnClickListener{
            val i = Intent(this, Customization::class.java)
            i.putExtra("iron", clicks)
            i.putExtra("clickMult", clickMultPurc)
            i.putExtra("clickIncr", clickIncrPurc)
            i.putExtra("townName", townName)
            i.putExtra("townAge", townAge)
            i.putExtra("userBirthdayMonth", birthdayMonth)
            i.putExtra("userBirthdayDate", birthdayDate)
            startActivity(i)
        }
    }
}