package com.example.widgetexploration

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import com.example.widgetexploration.databinding.ExplorationLayoutBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ExplorationLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ExplorationLayoutBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.checkBoxTransparency.setOnCheckedChangeListener { view, isChecked ->
            if(isChecked){
                binding.imageView.alpha=.1f
            }else{
                binding.imageView.alpha=1f
            }
        }

        binding.checkBoxTint.setOnCheckedChangeListener { view, isChecked ->
            if (isChecked){
                binding.imageView.setColorFilter(Color.argb(150,255,0,0))
            }else{
                binding.imageView.setColorFilter(Color.argb(0,0,0,0))
            }
        }
        
        binding.checkBoxReSize.setOnCheckedChangeListener { view, isChecked ->
            if (isChecked){
                binding.imageView.scaleX = 2f
                binding.imageView.scaleY=2f
            }else{
                binding.imageView.scaleX=1f
                binding.imageView.scaleY=1f
            }
        }

        binding.radioGroup.clearCheck()
        binding.radioGroup.setOnCheckedChangeListener{ group,checkedId ->
            var radioButton=group.findViewById<View>(checkedId) as RadioButton
            when(radioButton.id){
                R.id.radioButtonLondon ->
                    binding.textClock.timeZone="Europe/London"

                R.id.radioButtonBeijing ->
                    binding.textClock.timeZone="CST6CDT"

                R.id.radioButtonNewYork ->
                    binding.textClock.timeZone="America/New_York"
                R.id.radioButtonEuropeanEmpire ->
                    binding.textClock.timeZone="Europe/Brussels"
            }
        }

        binding.button.setOnClickListener{
            binding.textView.text=binding.editText.text
        }
        
        binding.switch1.setOnCheckedChangeListener { view, isChecked ->
            if(isChecked){
                binding.textView.visibility=View.VISIBLE
            }else{
                binding.textView.visibility=View.INVISIBLE
            }
        }
    }
}