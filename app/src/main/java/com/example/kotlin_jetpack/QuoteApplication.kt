package com.example.kotlin_jetpack

import android.app.Application
import com.example.kotlin_jetpack.api.QuoteService
import com.example.kotlin_jetpack.api.RetrofitHelper
import com.example.kotlin_jetpack.db.QuoteDatabase
import com.example.kotlin_jetpack.repository.QuotesRepository

class QuoteApplication: Application() {

    lateinit var quotesRepository: QuotesRepository
    override fun onCreate() {
        super.onCreate()
        initlize()
    }

    private fun initlize() {
        val quoteService = RetrofitHelper.getInstance().create(QuoteService::class.java)
        val  database = QuoteDatabase.getDatabase(applicationContext)
         quotesRepository = QuotesRepository(quoteService,database,applicationContext)
    }
}