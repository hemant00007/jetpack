package com.example.kotlin_jetpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_jetpack.viewmodels.MainViewModel
import com.example.kotlin_jetpack.viewmodels.MainviewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var authoradapter:MainAdapter
    lateinit var recycler :RecyclerView
    lateinit var mainviewModel:MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_main)
        recycler = findViewById(R.id.recyclerview)
       recycler.layoutManager=LinearLayoutManager(applicationContext)
        val name: String ="my name is hemant"
        val  repository = (application as QuoteApplication).quotesRepository
    mainviewModel = ViewModelProvider(this,MainviewModelFactory(repository)).get(MainViewModel::class.java)

        mainviewModel.quotes.observe(this,{
            authoradapter = MainAdapter(it.results)
            recycler.adapter=authoradapter

           // Log.d("HemantMVVM",it.results.toString())
           // Toast.makeText(this@MainActivity,it.results[0].content,Toast.LENGTH_LONG).show()
        })
    }
}