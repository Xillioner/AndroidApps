package com.example.expressyourself

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = "Nolan Bushnell"
        val yearOfBirth = 1943
        var currentYear = 2022
        var age: Int
        age = currentYear - yearOfBirth
        Log.i("info","$age")

        currentYear++
        Log.i("info","$name was born in $yearOfBirth and is $age years old. " +
                "Next year he will be ${currentYear-yearOfBirth} years old")

        val rating:Int = 4
        when (rating){
            1 -> Log.i("Oh dear! Rating = ","$rating starts")
            2 -> Log.i("Not good! Rating = ", "$rating stars")
            3 -> Log.i("Not bad! Rating = ", "$rating stars")
            4 -> Log.i("This if good! Rating = ", "$rating stars")
            5 -> Log.i("Amazing! Rating = ","$rating stars")
            else -> {
                Log.i("Error:", "$rating is not a valid rating")
            }
        }
    }
}