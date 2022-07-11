package com.example.dynamicarrayexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ourArray = IntArray(1000)
        for(element in 0..999) {
            ourArray[element] = element * 5

            Log.i("info", "element = $element")
            Log.i("info","ourArray[element] = ${ourArray[element]}")
        }

    }
}