package com.example.timetip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.timetip.databinding.ActivityMainBinding
import java.text.NumberFormat
import kotlin.math.ceil


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener { calaculatetip() }

    }

    private fun calaculatetip() {
        val sample=binding.cost.text.toString()
        val cost=sample.toDouble()
       val percent= binding.serviceOption.checkedRadioButtonId
        val service=when(percent){
            1->0.20
            2->0.18
            else -> 0.15
        }
        var tip=cost*service
        val check=binding.switching.isChecked
        if (check){
           tip=ceil(tip)
        }
        val tipresult=NumberFormat.getNumberInstance().format(tip)
       binding.tipResult.text=getString(R.string.tip_amount,tipresult)

    }
}