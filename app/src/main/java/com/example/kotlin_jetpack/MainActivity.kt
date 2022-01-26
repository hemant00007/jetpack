package com.example.kotlin_jetpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.kotlin_jetpack.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
       // val quoteobj = Quotes("this is quotes","hemant kumar")
     //  binding.mainv =quoteobj
       binding.quoteNames.text = "hello hemant"
       binding.quoteTextAuthor.text = "THis is author"
    }
}