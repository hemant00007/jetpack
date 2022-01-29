package com.example.kotlin_jetpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.kotlin_jetpack.api.QuoteService
import com.example.kotlin_jetpack.api.RetrofitHelper
import com.example.kotlin_jetpack.databinding.ActivityMainBinding
import com.example.kotlin_jetpack.repository.QuotesRepository
import com.example.kotlin_jetpack.viewmodels.MainViewModel
import com.example.kotlin_jetpack.viewmodels.MainviewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var mainviewModel:MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_main)
        val name: String ="my name is hemant"
        val  repository = (application as QuoteApplication).quotesRepository
    mainviewModel = ViewModelProvider(this,MainviewModelFactory(repository)).get(MainViewModel::class.java)

        mainviewModel.quotes.observe(this,{
           // Log.d("HemantMVVM",it.results.toString())
            Toast.makeText(this@MainActivity,it.results[0].content,Toast.LENGTH_LONG).show()
        })
    }
}