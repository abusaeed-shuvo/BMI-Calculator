package com.example.bmicalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.bmicalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnCalculate.setOnClickListener {
            val weight = binding.enterWeight.text.toString().toDouble()
            val height = binding.enterHeight.text.toString().toDouble() / 100

            val bmi = weight / (height * height)

            binding.showResult.text = String.format("Your BMI is: %.2f", bmi)

            binding.showDescription.text = when {
                bmi > 0.0 && bmi <= 18.5 -> "You are underweight please eat some more."
                bmi > 18.5 && bmi <= 24.9 -> "You are the correct weight."
                bmi > 24.9 && bmi <= 29.9 -> "You are slightly overweight"
                bmi > 29.9 && bmi <= 34.9 -> "You are indeed fat please do some exercise."
                bmi > 34.9 && bmi < 40.0 -> "You are indeed very fat eat less and do some exercise."
                bmi > 40 -> "You are obese Please consider your life choice."
                else -> "Something has gone wrong."
            }
        }

    }
}