package com.example.whendemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Enter an ocean, river or breed of dog
        val name:String = "Moscow"
        when(name){
            "Atlantic", "Pacific","Arctic" ->
                Log.i("Found:", "$name is an ocean")
            "Thames","Nile", "Mississippi" ->
                Log.i("Found:", "$name is a river")
            "Labrador","Beagle","Jack Russel" ->
                Log.i("Found","$name is a dog")
            else -> {
                Log.i("Not found:", "$name is not in database")
            }
        }

        var y = 10
        do {
            y++
            Log.i("In the do block and y=","$y")
        }
            while (y<10)

        fun getSum(a:Int,b:Int)=a+b
        Toast.makeText(this,"${getSum(2,3)}",Toast.LENGTH_SHORT).show()
    }
}