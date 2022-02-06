package com.tinku.bmiapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val back = findViewById<ConstraintLayout>(R.id.back)
        val txResult = findViewById<TextView>(R.id.txResult)
        val weight = findViewById<EditText>(R.id.weight)
        val fit = findViewById<EditText>(R.id.fit)
        val inch = findViewById<EditText>(R.id.inch)
        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            val weight: Int = weight.text.toString().toInt()
            val fit:Int = fit.text.toString().toInt()
            val inch: Int = inch.text.toString().toInt()

            val totalInch = fit*12+inch
            val totalCm = totalInch*2.53
            val totalM = totalCm/100
            val bmi = weight/(totalM*totalM)

            if(bmi>25){
                txResult.text = getString(R.string.overWeighted)
                back.setBackgroundColor(Color.RED)
            }
            else if(bmi<18){
                txResult.text = getString(R.string.underWeighted)
                back.setBackgroundColor(Color.YELLOW)
            }else{
                txResult.text = getString(R.string.healthy)
                back.setBackgroundColor(Color.GREEN)
            }

        }
    }
}